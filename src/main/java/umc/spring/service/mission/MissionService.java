package umc.spring.service.mission;

import umc.spring.dto.request.MissionRequestDTO;

public interface MissionService {
    void createMission(Long storeId, MissionRequestDTO.CreateMissionDTO createMissionDTO);
}
