package com.zalteam.restroomMap.controller;
import com.zalteam.restroomMap.domain.Keyword;
import com.zalteam.restroomMap.domain.Review;
import com.zalteam.restroomMap.service.KeywordService;
import com.zalteam.restroomMap.service.ReviewService;
import com.zalteam.restroomMap.web.ReviewForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ReviewController {

    private final ReviewService reviewService;
    private final KeywordService keywordService;


    /**
     * ReviewForm 을 이용한 데이터 저장
     */
    @PostMapping("/reviews")
    public Review addReview(@RequestBody @Valid ReviewForm form) {

        Review review = new Review();

        review.setStars(form.getStars());
        review.setDetailedReview(form.getDetailedReview());

        reviewService.saveReview(review);

        for (Keyword keyword : form.getKeywords()) {
            keyword.setReview(review);
            review.getKeywords().add(keyword);
            keywordService.saveKeyword(keyword);
        }

        return review;
    }
}
