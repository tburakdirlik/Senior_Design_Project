package com.project.senior_project_01.Entity;

import lombok.*;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "USER_ENTITY_")
@Table(name = "USER_TABLE_", uniqueConstraints = {@UniqueConstraint(name = "USERID_UNIQUE_", columnNames = "USER_ID_"),
                                                 @UniqueConstraint(name = "EMAIL_UNIQUE_",  columnNames = "EMAIL_")
                                                }
       )
public class User {

    @Id
    @SequenceGenerator(
            name = "USER_SEQUENCE_",
            sequenceName = "USER_SEQUENCE_",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "USER_SEQUENCE_"
    )
    @Column(
            name = "USER_ID_"
    )
    private int  userId;

    @Column(name = "NAME_", nullable = false)
    private String name;

    @Column(name = "SURNAME_", nullable = false)
    private String surName;

    @Column(name = "EMAIL_", nullable = false)
    private String email;

    @Column(name = "PASSWORD_", nullable = false)
    private String password;

    @Column(name = "ROLE_", nullable = false)
    private String authority;
}