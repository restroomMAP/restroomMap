package com.zalteam.restroomMap.service;
import com.zalteam.restroomMap.domain.Review;
import com.zalteam.restroomMap.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    /**
     * 리뷰 등록기능
     */
    @Transactional
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

}
