package com.project.senior_project_01.Service;
import lombok.Getter;
import lombok.Setter;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.project.senior_project_01.Entity.User;
import com.project.senior_project_01.Dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.senior_project_01.Repository.UserRepository;
import com.project.senior_project_01.Dto.Login.SignInDataTransferObject;
import com.project.senior_project_01.Dto.Login.SignUpDataTransferObject;
@Service
@Getter
@Setter
public class UserService {

    @Autowired UserRepository userRepository;
    @Autowired UserSession userSession;

    private String authority;
    private final String adminPassword= "95d4e78d733ac211d5950595d38c34a67e";// Special password that provide admin authority.

    public String createAuthority(SignUpDataTransferObject signUpDataTransferObject) {

        if     ( signUpDataTransferObject.getPassword().equals(adminPassword)) {  setAuthority("ADMIN"); }
        else   { setAuthority("CUSTOMER"); }
        return getAuthority();
    }

    public Response signUp(SignUpDataTransferObject signUpDataTransferObject) {

        Optional<User> signUpUser =  Optional.ofNullable(userRepository.findByEmail(signUpDataTransferObject.getEmail()));
        if (signUpUser.isPresent()){
            return  Response.builder()
                    .result("ERROR")
                    .message("You can not use this email to sign up, please choose different one")
                    .build();
        }
        User user = User.builder()  // If user is not created, create an user object here.
                .name(signUpDataTransferObject.getName())
                .surName(signUpDataTransferObject.getSurname())
                .email(signUpDataTransferObject.getEmail())
                .password(signUpDataTransferObject.getPassword())
                .authority(createAuthority(signUpDataTransferObject))
                .build();
        userRepository.save(user);

        return  Response.builder()
                .result("OK")
                .message("User created successfully")
                .build();
    }

    public Response signIn(SignInDataTransferObject signInDataTransferObject) {

        Optional<User> signInUser = Optional.ofNullable(userRepository.findByEmail(signInDataTransferObject.getEmail()));
        Response response= new Response();

        if (!signInUser.isPresent()) {// CASE 1 : Email is not correct.
            response.setResult("ERROR");
            response.setMessage("There is not a user with this email. Please give true email.");
            return response;
        }

        if (signInUser.isPresent() && signInUser.get().getPassword().equals(signInDataTransferObject.getPassword())) {
            response.setResult("SUCCESSFULL"); // CASE 2 : Email is correct, password is correct.
            response.setMessage("Email correct, password correct");
            openSession(signInUser.get());

        }

        if (signInUser.isPresent() && !signInUser.get().getPassword().equals(signInDataTransferObject.getPassword())) {
            response.setResult("UNSUCCESSFULL"); // CASE 3 : Email is correct, password not correct.
            response.setMessage("Email is correct, password is not correct");
            return response;
        }

        return response;
    }
    public void openSession (User user){
        userSession = new UserSession( user.getUserId(),
                user.getName(),
                user.getSurName(),
                user.getEmail(),
                user.getPassword(),
                user.getAuthority());
    }
    public UserSession getUserSessionData() {
        return userSession;
    }
}