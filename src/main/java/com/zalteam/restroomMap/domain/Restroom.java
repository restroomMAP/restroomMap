package com.zalteam.restroomMap.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restrooms")
@Getter @Setter
public class Restroom {
    @Id
    @GeneratedValue
    @Column(name = "restroom_id")
    private int id;

    @NotEmpty
    private String address;

    @NotEmpty
    private int floor;

    @NotEmpty
    private String gender;  // W(여자), M(남자), B(공용)

//    private POINT location;

    private String time;    // 이용시간

    @OneToMany(mappedBy = "restroom")
    private List<RestroomKeyword> restroomKeywords = new ArrayList<>();
}
