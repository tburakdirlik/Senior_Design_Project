package com.project.senior_project_01.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.project.senior_project_01.Dto.Response;
import com.project.senior_project_01.Service.UserService;
import com.project.senior_project_01.Service.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.senior_project_01.Dto.Login.SignInDataTransferObject;
import com.project.senior_project_01.Dto.Login.SignUpDataTransferObject;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signUp")
    @ResponseStatus(HttpStatus.CREATED)
    private Response signUp(@RequestBody SignUpDataTransferObject signUpDataTransferObject){
        return userService.signUp(signUpDataTransferObject);
    }
    @PostMapping("/signIn")
    private Response signIn(@RequestBody SignInDataTransferObject signInDataTransferObject){

        return userService.signIn(signInDataTransferObject);
    }
    @GetMapping("/session")
    public UserSession sessionData(){
        return userService.getUserSessionData();
    }
}


/*
        UserController class contain these endpoints:
            /signUp
            /signIn
        Request body of sign up implemented as 'SignUpDataTransferObject' class. This request process by /signUp endpoint.
        Request body of sign in implemented as 'SignInDataTransferObject' class. This request process by /signIn endpoint.
        When user sign in, we get user informations that sign in user with /session endpoint.
    */