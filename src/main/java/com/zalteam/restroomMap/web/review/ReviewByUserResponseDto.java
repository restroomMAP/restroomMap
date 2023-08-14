package com.zalteam.restroomMap.web.review;

import java.time.LocalDate;

public interface ReviewByUserResponseDto {

    int getStars();
    String getDetailedReview();
    LocalDate getAddedDate();

    String getAddress();
    String getFloor();
    String getGender();

    //private String profile_image;
    //private Integer restroomId;
}
