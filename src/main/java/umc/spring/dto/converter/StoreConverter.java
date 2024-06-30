package umc.spring.dto.converter;

import umc.spring.domain.Store;
import umc.spring.domain.enums.Category;
import umc.spring.dto.request.StoreRequestDTO;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO.CreateStoreDTO createStoreDTO){
        return Store.builder()
                .name(createStoreDTO.getName())
                .category (createStoreDTO.getCategory())
                .build();
    }
}
