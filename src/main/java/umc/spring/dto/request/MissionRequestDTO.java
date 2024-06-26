package umc.spring.dto.request;

import lombok.Getter;
import umc.spring.domain.enums.Status;

public class MissionRequestDTO {
    @Getter
    public static class CreateMissionDTO{
        private String content;
        private Long point;
        private String ownerCode;
    }

}
