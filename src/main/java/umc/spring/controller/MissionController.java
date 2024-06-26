package umc.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.BaseResponse;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.code.status.SuccessStatus;
import umc.spring.dto.request.MissionRequestDTO;
import umc.spring.dto.request.StoreRequestDTO;
import umc.spring.service.mission.MissionService;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mission")
public class MissionController {
    private final MissionService missionService;

    @PostMapping("/{storeId}")
    public BaseResponse<Void> createMission(@PathVariable Long storeId, @RequestBody MissionRequestDTO.CreateMissionDTO createMissionDTO){
        try {
            missionService.createMission(storeId,createMissionDTO);
            return BaseResponse.of(SuccessStatus.MISSION_CREATED,null);
        } catch (NoSuchElementException e) {
            return BaseResponse.onFailure(ErrorStatus._BAD_REQUEST.getMessage(), ErrorStatus._BAD_REQUEST.getCode(), null);
        }

    }
}
