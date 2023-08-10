package com.zalteam.restroomMap.repository;
import com.zalteam.restroomMap.domain.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class ReviewRepository {

    @PersistenceContext
    private final EntityManager em;

    /**
     * 리뷰 등록
     */
    public Review save(Review review) {
        em.persist(review);
        return review;
    }
}
