package umc.easyexcel.web.controller;

import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.*;
import org.springframework.web.bind.annotation.*;
import umc.easyexcel.apiPayload.ApiResponse;
import umc.easyexcel.converter.*;
import umc.easyexcel.domain.*;
import umc.easyexcel.domain.enums.*;
import umc.easyexcel.service.ShortcutKeyService.*;
import umc.easyexcel.web.dto.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shortcut-key")
public class ShortcutKeyController {

    private final ShortcutKeyQueryService shortcutKeyQueryService;

    @GetMapping("/category")
    @Operation(summary = "단축키 조회 API", description = "카테고리별 단축키를 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ShortcutKeyResponseDto.ShortcutKeyListDTO.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ApiResponse.class)))
    })
    public ApiResponse<ShortcutKeyResponseDto.ShortcutKeyListDTO> getShortcutKeysByCategory(
            @RequestParam("type") ShortcutKeyCategory category) {

        List<ShortcutKey> shortcutKeyList = shortcutKeyQueryService.getShortcutKeysByCategory(category);
        return ApiResponse.onSuccess(ShortcutKeyConverter.shortcutKeyListDTO(shortcutKeyList, category.name()));
    }

    @GetMapping("/search")
    @Operation(summary = "단축키 검색 API", description = "Explanation 또는 Detail Explanation을 기준으로 단축키를 검색합니다.")

    public ApiResponse<ShortcutKeyResponseDto.ShortcutKeySearchDTO> getFunctionsSearchList(
            @RequestParam(name = "keyword") String keyword) {

        List<ShortcutKey> searchResult = shortcutKeyQueryService.searchShortcutKeys(keyword);
        if (searchResult.isEmpty()) {
            return ApiResponse.onFailure("EMPTY_SEARCH", "검색 결과가 없습니다.", null);
        }
        return ApiResponse.onSuccess(ShortcutKeyConverter.shortcutKeySearchDTO(searchResult,keyword));
    }


}



