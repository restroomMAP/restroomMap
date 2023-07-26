package com.zalteam.restroomMap.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private int id;

    @NotEmpty
    private int stars;

    @Lob
    private String review;

    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "review")
    private List<ReviewKeyword> reviewKeywords = new ArrayList<>();
}
