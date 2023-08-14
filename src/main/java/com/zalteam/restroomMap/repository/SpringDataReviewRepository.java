package com.zalteam.restroomMap.repository;


import com.zalteam.restroomMap.domain.Review;
import com.zalteam.restroomMap.web.review.ReviewByRestroomResponseDto;
import com.zalteam.restroomMap.web.review.ReviewByUserResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataReviewRepository extends JpaRepository<Review, Integer> {
    @Query(value = "SELECT r.stars as stars, r.detailed_review as detailedReview, r.added_date as addedDate, rt.address as address, rt.floor as floor, rt.gender as gender "
            + "FROM reviews as r "
            + "inner join restrooms as rt "
            + "on r.restroom_id=rt.restroom_id "
            + "where r.user_id= :user_id", nativeQuery = true)
    List<ReviewByUserResponseDto> findAllByUserId(@Param("user_id") Integer user_id);

    @Query(value = "SELECT r.stars as stars, r.detailed_review as detailedReview, r.added_date as addedDate, u.nickname as nickname "
            + "FROM reviews as r "
            + "inner join users as u "
            + "on r.user_id=u.user_id "
            + "where r.restroom_id= :restroom_id", nativeQuery = true)
    List<ReviewByRestroomResponseDto> findAllByRestroomId(@Param("restroom_id") Integer restroom_id);
}
