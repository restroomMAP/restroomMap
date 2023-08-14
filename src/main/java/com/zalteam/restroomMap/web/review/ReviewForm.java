package com.zalteam.restroomMap.web.review;

import com.zalteam.restroomMap.domain.Keyword;
import lombok.Data;

import java.util.List;

@Data
public class ReviewForm {

    // 사용자로부터 입력받는 데이터
    private Integer stars;
    private String detailedReview;
    private List<Keyword> keywords;

    public ReviewForm(Integer stars, String detailedReview) {
        this.stars = stars;
        this.detailedReview = detailedReview;
    }


    public ReviewForm() {
    }
}
