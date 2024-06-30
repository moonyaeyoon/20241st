package umc.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.BaseResponse;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.code.status.SuccessStatus;
import umc.spring.dto.request.StoreRequestDTO;
import umc.spring.service.store.StoreService;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/store")
public class StoreController {
    private final StoreService storeService;

    @PostMapping("/{regionId}")
    public BaseResponse<Void> createStore(@PathVariable Long regionId, @RequestBody StoreRequestDTO.CreateStoreDTO createStoreDTO){
        try {
            storeService.createStore(regionId,createStoreDTO);
            return BaseResponse.of(SuccessStatus.STORE_CREATED,null);
        } catch (NoSuchElementException e) {
            return BaseResponse.onFailure(ErrorStatus._BAD_REQUEST.getMessage(), ErrorStatus._BAD_REQUEST.getCode(), null);
        }

    }




}
