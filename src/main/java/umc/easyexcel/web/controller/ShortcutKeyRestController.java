package umc.easyexcel.web.controller;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.*;
import org.springframework.web.bind.annotation.*;
import umc.easyexcel.apiPayload.ApiResponse;
import umc.easyexcel.apiPayload.code.status.ErrorStatus;
import umc.easyexcel.apiPayload.exception.handler.ShortcutKeyHandler;
import umc.easyexcel.converter.*;
import umc.easyexcel.domain.*;
import umc.easyexcel.domain.enums.*;
import umc.easyexcel.service.ShortcutKeyService.*;
import umc.easyexcel.web.dto.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shortcut-key")
public class ShortcutKeyRestController {

    private final ShortcutKeyQueryService shortcutKeyQueryService;

    @GetMapping("/category")
    @Operation(summary = "단축키 조회 API", description = "Query String으로 단축키 카테고리 enum 값을 주세요. Ex: FILE_EXECUTION >> '파일 실행'과 관련된 단축키 검색 결과 조회")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ShortcutKeyResponseDto.ShortcutKeyListDTO.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ApiResponse.class)))
    })
    public ApiResponse<ShortcutKeyResponseDto.ShortcutKeyListDTO> getShortcutKeyByCategory(
            @RequestParam(value = "type", required = false) ShortcutKeyCategory category) {
        if (category == null) {
            throw new ShortcutKeyHandler(ErrorStatus.INVALID_PARAMETER);
        }
        List<ShortcutKey> shortcutKeyList = shortcutKeyQueryService.getShortcutKeysByCategory(category);
        if (shortcutKeyList.isEmpty()) {
            throw new ShortcutKeyHandler(ErrorStatus.SHORTCUTKEY_NOT_FOUND);
        }
        return ApiResponse.onSuccess(ShortcutKeyConverter.shortcutKeyListDTO(shortcutKeyList, category.name()));
    }

    @GetMapping("/search")
    @Operation(summary = "단축키 검색 API", description = "Query String으로 keyword를 주세요. Ex: 셀 >> 셀(범위) 붙여넣기, 선택된 셀로 이동 등 '셀'이 포함된 검색 결과 조회<br>유사한 단어를 포함하여 검색합니다. Ex: 오픈 >> 통합문서 열기")

    public ApiResponse<ShortcutKeyResponseDto.ShortcutKeySearchDTO> getShortcutKeySearchList(
            @RequestParam(name = "keyword") String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            throw new ShortcutKeyHandler(ErrorStatus.INVALID_PARAMETER);
        }
        List<ShortcutKey> searchResult = shortcutKeyQueryService.searchShortcutKeys(keyword);
        if (searchResult.isEmpty()) {
            throw new ShortcutKeyHandler(ErrorStatus.EMPTY_SEARCH);
        }
        return ApiResponse.onSuccess(ShortcutKeyConverter.shortcutKeySearchDTO(searchResult,keyword));
    }


}
