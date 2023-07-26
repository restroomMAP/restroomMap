package com.zalteam.restroomMap.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="keywords")
public class Keyword {

    @Id
    @GeneratedValue
    @Column(name = "keyword_id")
    private int id;

    @OneToMany(mappedBy = "keyword")
    private List<ReviewKeyword> reviewKeywords = new ArrayList<>();

    @OneToMany(mappedBy = "keyword")
    private List<RestroomKeyword> restroomKeywords = new ArrayList<>();
    private String keyword;
}
