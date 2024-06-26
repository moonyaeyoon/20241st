package umc.spring.dto.converter;

import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.dto.request.ReviewRequestDTO;
import umc.spring.dto.request.StoreRequestDTO;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO.CreateReviewDTO createReviewDTO){
        return Review.builder()
                .ratingStar(createReviewDTO.getRatingStar())
                .content(createReviewDTO.getContent())
                .imgUrl(createReviewDTO.getImgUrl())
                .build();
    }
}
