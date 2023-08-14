package com.zalteam.restroomMap.service;
import com.zalteam.restroomMap.domain.Review;
import com.zalteam.restroomMap.repository.SpringDataReviewRepository;
import com.zalteam.restroomMap.web.review.ReviewByRestroomResponseDto;
import com.zalteam.restroomMap.web.review.ReviewByUserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewService {

    private final SpringDataReviewRepository springDataReviewRepository;

    /**
     * 리뷰 등록기능
     */
    @Transactional
    public Review saveReview(Review review) {
        return springDataReviewRepository.save(review);
    }


    /**
     * 리뷰 수정기능
     */
//    @Transactional
//    public Review updateReview(Review review) {
//        return springDataReviewRepository.
//    }
//

    /**
     * 사용자별 리뷰목록 조회 기능
     */
    public List<ReviewByUserResponseDto> findReviewByUser(Integer userId) {
        return springDataReviewRepository.findAllByUserId(userId);
    }



    /**
     * 화장실별 리뷰목록 조회 기능
     */
    public List<ReviewByRestroomResponseDto> findReviewByRestroom(Integer restroomId) {
        return springDataReviewRepository.findAllByRestroomId(restroomId);
    }


}
