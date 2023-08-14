package com.zalteam.restroomMap.web.review;

import java.time.LocalDate;

public interface ReviewByRestroomResponseDto {
    int getStars();
    String getDetailedReview();
    LocalDate getAddedDate();
    String getNickname();

    //private String profile_image;
    //private Integer restroomId;
}
