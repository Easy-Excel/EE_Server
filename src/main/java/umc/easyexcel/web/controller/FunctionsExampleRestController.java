package umc.easyexcel.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.easyexcel.apiPayload.ApiResponse;
import umc.easyexcel.converter.FunctionsExampleConverter;
import umc.easyexcel.domain.mapping.FunctionsExample;
import umc.easyexcel.service.FunctionsExampleService.FunctionsExampleService;
import umc.easyexcel.web.dto.FunctionsExampleResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/functions")
public class FunctionsExampleRestController {
    private final FunctionsExampleService functionsExampleService;

    @GetMapping("/{function_id}/examples")
    @Operation(summary = "함수 예제 조회 API", description = "함수 예제를 조회합니다")
    public ApiResponse<FunctionsExampleResponseDTO.FunctionsExampleListDTO> findById(@PathVariable("function_id") Long functionId) {
        List<FunctionsExample> functionsExampleList = functionsExampleService.getFunctionsExampleList(functionId);
        return ApiResponse.onSuccess(FunctionsExampleConverter.functionsExampleListDTO(functionsExampleList, functionId));
    }
}
