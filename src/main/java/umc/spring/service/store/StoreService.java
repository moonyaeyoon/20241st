package umc.spring.service.store;
import umc.spring.dto.request.StoreRequestDTO;

public interface StoreService {

    void createStore( Long regionId,  StoreRequestDTO.CreateStoreDTO createStoreDTO);

}
