package umc.spring.dto.response;

import lombok.*;
import umc.spring.domain.enums.Status;

public class MissionResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class JoinMissionDTO{
        private Long userId;
        private Long missionId;
        private Status status;
    }
}

