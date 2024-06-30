package umc.spring.service.mission;

import umc.spring.domain.mapping.UserMission;
import umc.spring.dto.request.MissionRequestDTO;
import umc.spring.dto.response.MissionResponseDTO;

public interface MissionService {
    void createMission(Long storeId, MissionRequestDTO.CreateMissionDTO createMissionDTO);
    UserMission joinMission (Long userId, Long missionId);
}
