package com.project.senior_project_01.Dto.Login;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignInDataTransferObject {

    private String email;
    private String password;

}