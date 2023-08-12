package com.zalteam.restroomMap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "reviews")
@EntityListeners(AuditingEntityListener.class)
public class Review {

    @Id @GeneratedValue
    @Column(name = "review_id")
    private Integer id;

    @NotNull(message="별점을 입력해주세요.")
    @Column(name = "stars")
    private Integer stars;

    @Lob
    @Column(name = "detailed_review")
    private String detailedReview;

    @CreatedDate
    @Column(name = "added_date")
    private LocalDate addedDate;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")       //FK가 user_id
    private User user;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restroom_id")
    private Restroom restroom;


    @JsonIgnore
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy="review"       //mappedBy속성 값은 키워드 클래스에서 정의한 Review클래스의 변수명
    )
    private List<Keyword> keywords = new ArrayList<>();

    public Review() {
    }


/**
    @ElementCollection
    @CollectionTable(
            name = "Keyword",
            joinColumns = @JoinColumn(name="review_id")
    )
    private List<String> keywords;
*/
}
