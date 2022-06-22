package com.project.senior_project_01.Service;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Service
public class UserSession {

    private Integer userId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String authority;

}
