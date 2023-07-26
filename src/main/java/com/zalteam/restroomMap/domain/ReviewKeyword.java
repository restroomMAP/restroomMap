package com.zalteam.restroomMap.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "review_keywords")
@Getter @Setter
public class ReviewKeyword {

    @Id @GeneratedValue
    @Column(name = "review_keyword_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "keyword_id")
    private Keyword keyword;
}
