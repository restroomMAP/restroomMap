package com.zalteam.restroomMap.controller;
import com.zalteam.restroomMap.domain.Keyword;
import com.zalteam.restroomMap.domain.Review;
import com.zalteam.restroomMap.service.KeywordService;
import com.zalteam.restroomMap.service.ReviewService;
import com.zalteam.restroomMap.web.review.ReviewByRestroomResponseDto;
import com.zalteam.restroomMap.web.review.ReviewForm;
import com.zalteam.restroomMap.web.review.ReviewByUserResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ReviewController {

    @Autowired
    private ModelMapper modelMapper;

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


    //리뷰 조회(사용자 별)      URL: /reviews/{userId}
    @GetMapping("user/{userId}/reviews")
    public List<ReviewByUserResponseDto> findByUserId(@PathVariable Integer userId) {
        return reviewService.findReviewByUser(userId);
    }



    //리뷰 조회(화장실 별)      URL: /reviews/{restroomId}
    @GetMapping("restroom/{restroomId}/reviews")
    public List<ReviewByRestroomResponseDto> findByRestroomId(@PathVariable Integer restroomId) {
        return reviewService.findReviewByRestroom(restroomId);
    }



    //리뷰 수정     URL: /reviews/{reviewId}
/*    @PatchMapping("/reviews/{reviewId}")
    public Review updateReview(@PathVariable Integer reviewId, @RequestBody @Valid ReviewForm form) {

        Review updatedReview = springDataReviewRepository

        editedReview.setStars(form.getStars());
        editedReview.setDetailedReview(form.getDetailedReview());

        for (Keyword keyword : form.getKeywords()) {
            keyword.setReview(editedReview);
            editedReview.getKeywords().add(keyword);
            keywordService.saveKeyword(keyword);
        }

        return reviewService.updateReview(editedReview);
    }
*/

}
