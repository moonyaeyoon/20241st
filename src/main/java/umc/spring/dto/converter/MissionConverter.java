package umc.spring.dto.converter;

import umc.spring.domain.Mission;
import umc.spring.dto.request.MissionRequestDTO;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO.CreateMissionDTO createMissionDTO){
        return  Mission.builder()
                .content(createMissionDTO.getContent())
                .ownerCode(createMissionDTO.getOwnerCode())
                .status(createMissionDTO.getStatus())
                .build();
    }
}
