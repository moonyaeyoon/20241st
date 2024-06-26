package umc.spring.dto.request;

import lombok.Getter;
import umc.spring.domain.enums.Category;
import umc.spring.domain.enums.Status;

public class StoreRequestDTO {

    @Getter
    public static class CreateStoreDTO {
        private String name;
        private Category category;
    }


}
