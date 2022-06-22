package com.project.senior_project_01.Dto.Login;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDataTransferObject {

    private String name;
    private String surname;
    private String email;
    private String password;

}
