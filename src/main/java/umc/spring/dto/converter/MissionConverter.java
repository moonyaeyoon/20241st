package umc.spring.dto.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.enums.Status;
import umc.spring.domain.mapping.UserMission;
import umc.spring.dto.request.MissionRequestDTO;
import umc.spring.dto.response.MissionResponseDTO;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO.CreateMissionDTO createMissionDTO){
        return  Mission.builder()
                .content(createMissionDTO.getContent())
                .ownerCode(createMissionDTO.getOwnerCode())
                .build();
    }

    public static UserMission toJoinMission(User user, Mission mission, Status status){
        return UserMission.builder()
                .user(user)
                .mission(mission)
                .status(status)
                .build();
    }
}
