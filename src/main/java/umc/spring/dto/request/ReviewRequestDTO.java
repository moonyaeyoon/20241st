package umc.spring.dto.request;

import lombok.Getter;
import umc.spring.domain.enums.Category;

public class ReviewRequestDTO {
    @Getter
    public static class CreateReviewDTO {
        private Long ratingStar;
        private String content;
        private String imgUrl;
    }
}

