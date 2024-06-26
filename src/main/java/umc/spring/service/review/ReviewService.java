package umc.spring.service.review;

import umc.spring.dto.request.ReviewRequestDTO;

public interface ReviewService {
    void createReview(Long userId, Long storeId, ReviewRequestDTO.CreateReviewDTO createReviewDTO);
}
