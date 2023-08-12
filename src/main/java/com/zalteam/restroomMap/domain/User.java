package com.zalteam.restroomMap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "nickname", unique = true)
    @NotEmpty
    private String nickname;

    @Column(name = "email", unique = true)
    @NotEmpty
    private String email;

    @Column(name = "name")
    @NotEmpty
    private String name;

//    private POINT userLocation;

    @NotEmpty
    @Column(name = "password")
    private String password;


//    private String profile_image;
    @JsonIgnore
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "user"
    )
    private List<Review> reviews = new ArrayList<>();

/*
    public User(List<Review> reviews) {
        this.reviews = reviews;
    }
*/

    public User() {
    }
}
