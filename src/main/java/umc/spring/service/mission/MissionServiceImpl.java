package umc.spring.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.dto.request.MissionRequestDTO;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;

import static umc.spring.dto.converter.MissionConverter.toMission;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionServiceImpl implements MissionService{
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    public void createMission(Long storeId, MissionRequestDTO.CreateMissionDTO createMissionDTO){
        Store store = findStoreById(storeId);
        Mission mission = toMission(createMissionDTO);
        mission.setStore(store);
        missionRepository.save(mission);
    }

    private Store findStoreById(Long storeId){
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("가게를 찾을 수 없습니다."));
    }
}
