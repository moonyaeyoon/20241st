package umc.spring.dto.request;

import lombok.Getter;
import umc.spring.domain.enums.Category;

public class StoreRequestDTO {

    @Getter
    public static class CreateStoreDTO {
        private String name;
        private Category category;
    }
}
