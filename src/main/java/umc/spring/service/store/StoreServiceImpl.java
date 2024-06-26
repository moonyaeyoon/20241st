package umc.spring.service.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.dto.request.StoreRequestDTO;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.StoreRepository;

import static umc.spring.dto.converter.StoreConverter.toStore;


@Service
@RequiredArgsConstructor
@Transactional
public class StoreServiceImpl implements StoreService {
    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;

    @Override
    public void createStore( Long regionId,  StoreRequestDTO.CreateStoreDTO createStoreDTO){
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new RuntimeException("지역을 찾을 수 없습니다."));
        Store store = toStore(createStoreDTO);
        store.setRegion(region);
        storeRepository.save(store);

    }
}
