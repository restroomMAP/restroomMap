package com.zalteam.restroomMap.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="restroom_keywords")
@Getter @Setter
public class RestroomKeyword {

    @Id @GeneratedValue
    @Column(name = "restroom_keyword_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "restroom_id")
    private Restroom restroom;

    @ManyToOne
    @JoinColumn(name = "keyword_id")
    private Keyword keyword;
}
