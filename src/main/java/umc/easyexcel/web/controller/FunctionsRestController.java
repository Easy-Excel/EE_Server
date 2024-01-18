package umc.easyexcel.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.easyexcel.apiPayload.ApiResponse;
import umc.easyexcel.service.FunctionsService.FunctionsService;
import umc.easyexcel.web.dto.FunctionsResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/functions")
public class FunctionsRestController {

    private final FunctionsService functionsService;

    @GetMapping("/{function_id}")
    public ApiResponse<FunctionsResponseDTO.GetFunctionsDTO> findById(@PathVariable("function_id") Long functionId) {
        FunctionsResponseDTO.GetFunctionsDTO responseDTO = functionsService.getFunctionsByFunctionId(functionId);
        return ApiResponse.onSuccess(responseDTO);
    }
}
