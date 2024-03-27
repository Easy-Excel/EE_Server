package umc.easyexcel.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.easyexcel.apiPayload.ApiResponse;
import umc.easyexcel.converter.CategoryConverter;
import umc.easyexcel.converter.FunctionsExampleConverter;
import umc.easyexcel.domain.enums.FunctionCategory;
import umc.easyexcel.domain.mapping.FunctionsExample;
import umc.easyexcel.service.CategoryService.CategoryService;
import umc.easyexcel.service.FunctionsExampleService.FunctionsExampleService;
import umc.easyexcel.service.FunctionsService.FunctionsService;
import umc.easyexcel.web.dto.CategoryResponseDTO;
import umc.easyexcel.web.dto.FunctionsExampleResponseDTO;
import umc.easyexcel.web.dto.FunctionsResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RequestParam;
import umc.easyexcel.converter.FunctionsConverter;
import umc.easyexcel.domain.Functions;
import umc.easyexcel.service.FunctionsService.FunctionsQueryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/functions")
public class FunctionsRestController {

    private final FunctionsService functionsService;
    private final CategoryService categoryService;
    private final FunctionsExampleService functionsExampleService;

    @GetMapping("/{function_id}")
    public ApiResponse<FunctionsResponseDTO.GetFunctionsDTO> findById(@PathVariable("function_id") Long functionId) {
        FunctionsResponseDTO.GetFunctionsDTO responseDTO = functionsService.getFunctionsByFunctionId(functionId);
        return ApiResponse.onSuccess(responseDTO);
    }
    private final FunctionsQueryService functionsQueryService;

    @GetMapping("/list")
    @Operation(summary = "문자별 함수 조회 API", description = "Query String으로 알파벳 2개를 주세요. 대소문자 상관없습니다. " +
            "Ex: A,H >> A~H")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
    })
    public ApiResponse<FunctionsResponseDTO.FunctionsSortingListDTO> getFunctionsSortingList(@RequestParam(name = "firstSorting") String firstSorting,
                                                                               @RequestParam(name = "lastSorting") String lastSorting){

        List<Functions> functionsSortingList = functionsQueryService.getFunctionsSortingList(firstSorting,lastSorting);
        return ApiResponse.onSuccess(FunctionsConverter.functionsListDTO(functionsSortingList,firstSorting,lastSorting));
    }

    @GetMapping("/search")
    @Operation(summary = "함수 검색 API", description = "Query String으로 keyword를 주세요. 대소문자 상관없습니다. " +
            "Ex: CO >> COUNT, COLUMN 등 CO가 포함된 검색 결과 조회")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
    })
    public ApiResponse<FunctionsResponseDTO.FunctionsSearchListDTO> getFunctionsSearchList(@RequestParam(name = "keyword") String keyword){

        List<Functions> functionsSearchList = functionsQueryService.getFunctionsSearchList(keyword);
        return ApiResponse.onSuccess(FunctionsConverter.functionsSerachListDTO(functionsSearchList,keyword));
    }

    @GetMapping("/category")
    @Operation(summary = "범주별 함수 리스트 조회 API", description = "범주별 함수 리스트를 조회합니다")
    public ApiResponse<CategoryResponseDTO.InquiryListDTO> getFunctionsList(@RequestParam(name = "type", defaultValue = "DATE_TIME") FunctionCategory category) {
        List<Functions> functionsByCategoryList = categoryService.getFunctionsByCategoryList(category);
        return ApiResponse.onSuccess(CategoryConverter.inquiryListDTO(functionsByCategoryList, category.name()));
    }

    @GetMapping("/{function_id}/examples")
    @Operation(summary = "함수 예제 조회 API", description = "함수 예제를 조회합니다")
    public ApiResponse<FunctionsExampleResponseDTO.FunctionsExampleListDTO> findByFunctionId(@PathVariable("function_id") Long functionId) {
        List<FunctionsExample> functionsExampleList = functionsExampleService.getFunctionsExampleList(functionId);
        return ApiResponse.onSuccess(FunctionsExampleConverter.functionsExampleListDTO(functionsExampleList, functionId));
    }
}
