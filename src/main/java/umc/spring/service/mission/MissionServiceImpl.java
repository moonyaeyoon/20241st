package umc.spring.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.domain.enums.Status;
import umc.spring.domain.mapping.UserMission;
import umc.spring.dto.request.MissionRequestDTO;
import umc.spring.dto.response.MissionResponseDTO;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.repository.UserMissionRepository;
import umc.spring.repository.UserRepository;

import static umc.spring.dto.converter.MissionConverter.toJoinMission;
import static umc.spring.dto.converter.MissionConverter.toMission;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionServiceImpl implements MissionService{
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    public void createMission(Long storeId, MissionRequestDTO.CreateMissionDTO createMissionDTO){
        Store store = findStoreById(storeId);
        Mission mission = toMission(createMissionDTO);
        mission.setStore(store);
        missionRepository.save(mission);
    }

    @Override
    public UserMission joinMission (Long userId, Long missionId){
        User user = findUserById(userId);
        Mission mission = findMissionById(missionId);
        UserMission userMission = toJoinMission(user,mission,Status.PROGRESS);
        userMission.setMission(mission);
        userMission.setUser(user);
        return userMissionRepository.save(userMission);
    }

    private Store findStoreById(Long storeId){
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("가게를 찾을 수 없습니다."));
    }
    private User findUserById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
    }

    private Mission findMissionById(Long missionId){
        return missionRepository.findById(missionId)
                .orElseThrow(() -> new RuntimeException("미션을 찾을 수 없습니다."));
    }
}
