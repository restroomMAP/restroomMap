package com.zalteam.restroomMap.web;

import com.zalteam.restroomMap.domain.Keyword;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ReviewForm {

    // 자동으로 생성되는 데이터
    private Integer id;
    private LocalDate addedDate;


    // 사용자로부터 입력받는 데이터
    private Integer stars;
    private String detailedReview;
    private List<Keyword> keywords;


    // 후기 목록 화면에 뿌려줄때 사용할 데이터
    private Integer userId;
    private String nickname;


    public ReviewForm(Integer stars, String detailedReview) {
        this.stars = stars;
        this.detailedReview = detailedReview;
    }


    public ReviewForm() {
    }
}
