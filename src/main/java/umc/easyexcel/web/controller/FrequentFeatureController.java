package umc.easyexcel.web.controller;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.responses.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;
import umc.easyexcel.apiPayload.ApiResponse;
import umc.easyexcel.converter.*;
import umc.easyexcel.domain.*;
import umc.easyexcel.service.FrequentFeatureService.*;
import umc.easyexcel.web.dto.*;

import java.util.*;
import java.util.stream.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/etc")
public class FrequentFeatureController {

    private final FrequentFeatureQueryService frequentFeatureQueryService;

    @GetMapping("/frequent-functions")
    @Operation(summary = "자주쓰이는기능 조회 API", description = "자주쓰이는기능을 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK, 성공", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = FrequentFeatureResponseDto.FrequentFeatureListDTO.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request, 실패", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ApiResponse.class)))
    })
    public ApiResponse<FrequentFeatureResponseDto.FrequentFeatureListDTO> getSimpleFrequentFeatures() {
        List<FrequentFeature> frequentFeature = frequentFeatureQueryService.getAllFrequentFeatures();
        List<FrequentFeatureResponseDto.FrequentFeatureDTO> frequentFeatureDtoList = frequentFeature.stream()
                .map(FrequentFeatureConverter::toResponseSimpleDTO)
                .collect(Collectors.toList());

        return ApiResponse.onSuccess(FrequentFeatureResponseDto.FrequentFeatureListDTO.builder()
                .frequentFeatures(frequentFeatureDtoList)
                .listSize(frequentFeatureDtoList.size())
                .build());
    }

    @GetMapping("/frequent-functions/{frequent_function_id}")
    @Operation(summary = "특정 자주쓰이는기능 조회 API", description = "특정 자주쓰이는기능을 조회합니다.")
    public ApiResponse<Object> getFrequentFeatureById(
            @PathVariable("frequent_function_id") Long frequentFeatureId) {
        FrequentFeature frequentFeature = frequentFeatureQueryService.getFrequentFeatureById(frequentFeatureId);

        if (frequentFeature == null) {
            return ApiResponse.onFailure("4000", "Bad Request", "해당 ID:" + frequentFeatureId + "에 대한 자주 사용되는 기능을 찾을 수 없습니다.");
        }

        FrequentFeatureResponseDto.FrequentFeatureDetailDTO responseDTO = FrequentFeatureConverter.toResponseDetailedDTO(frequentFeature);
        return ApiResponse.onSuccess(responseDTO);
    }
}
