package com.zalteam.restroomMap.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="keywords")
@Getter @Setter
public class Keyword {

    @Id @GeneratedValue
    @Column(name = "keyword_id")
    private Integer id;

    @Column(name = "contents")
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="review_id")
    private Review review;

    @Override
    public String toString() {
        return "Keyword [contents=" + contents + "]";
    }
}
