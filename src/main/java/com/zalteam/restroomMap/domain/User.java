package com.zalteam.restroomMap.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int id;

    @Column(unique = true)
    @NotEmpty
    private String nickname;

    @Column(unique = true)
    @NotEmpty
    private String email;

//    private POINT userLocation;

    @NotEmpty
    private String password;

    @NotEmpty
    private String name;

//    private String profile_image;
}
