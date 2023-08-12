package com.zalteam.restroomMap.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "restrooms")
@Getter @Setter
public class Restroom {


    @Id
    @GeneratedValue
    @Column(name = "restroom_id")
    private Integer id;

    @NotEmpty
    private String address;

    @NotEmpty
    private Integer floor;

    @NotEmpty
    private String gender;  // W(여자), M(남자), B(공용)

//    private POINT location;

    private String time;    // 이용시간

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy="restroom"
    )
    private List<Review> reviews = new ArrayList<>();

    // keywords 필드는 좀 더 알아봐야함
    private Set<String> keywords = new LinkedHashSet<>();
}
