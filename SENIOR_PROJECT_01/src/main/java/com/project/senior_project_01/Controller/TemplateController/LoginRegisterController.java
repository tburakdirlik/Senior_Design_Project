package com.project.senior_project_01.Controller.TemplateController;

import org.springframework.stereotype.Controller;
import com.project.senior_project_01.Dto.Response;
import com.project.senior_project_01.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.senior_project_01.Dto.Login.SignInDataTransferObject;
import com.project.senior_project_01.Dto.Login.SignUpDataTransferObject;
@Controller
public class LoginRegisterController {

    @Autowired UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login")
    public String loginPost(@ModelAttribute("signInDataTransferObject") SignInDataTransferObject signInDataTransferObject){

        Response response = userService.signIn(signInDataTransferObject);
        if (response.getMessage().equals("Email correct, password correct") && response.getResult().equals("SUCCESSFULL")){
            if (signInDataTransferObject.getPassword().equals("95d4e78d733ac211d5950595d38c34a67e")){
                return "adminHome";
            }
            if (!signInDataTransferObject.getPassword().equals("95d4e78d733ac211d5950595d38c34a67e")){
                //return ""; this is a structure that only allows admin login, customer side disabled.
            }
        }else {
            return "redirect:/login";
        }
        return "";
    }

    @GetMapping("/register")
    public String registerGet (){
        return "register";
    }

    @PostMapping("/register")
    public void registerPost (@ModelAttribute("signUpDataTransferObject") SignUpDataTransferObject signUpDataTransferObject) {
        userService.signUp(signUpDataTransferObject);
    }
}
