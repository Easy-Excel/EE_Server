package umc.easyexcel.web.controller;

import io.swagger.annotations.*;
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
    @ApiOperation(value = "단축키 조회 API", notes = "카테고리별 단축키를 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ShortcutKeyResponseDto.ShortcutKeyListDTO.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ApiResponse.class)))
    })
    public ApiResponse<ShortcutKeyResponseDto.ShortcutKeyListDTO> getShortcutKeysByCategory(
            @RequestParam("type") ShortcutKeyCategory category) {

        List<ShortcutKey> shortcutKeyList = shortcutKeyQueryService.getShortcutKeysByCategory(category);
        return ApiResponse.onSuccess(ShortcutKeyConverter.shortcutKeyListDTO(shortcutKeyList, category.name()));
    }
}



