package umc.easyexcel.web.dto;

import lombok.*;
import umc.easyexcel.domain.*;

import java.util.*;
import java.util.stream.*;

@Getter
@AllArgsConstructor
public class ShortcutKeyResponseDto {

    private Long id;
    private String explanation;
    private String detailExplanation;
    private String category;
    private List<String> windowKey;
    private List<String> macKey;

    public static ShortcutKeyResponseDto fromEntity(ShortcutKey shortcutKey) {

        List<String> windowKeyContents = shortcutKey.getWindowKeys().stream()
                .map(WindowKey::getContent)
                .collect(Collectors.toList());

        List<String> macKeyContents = shortcutKey.getMacKeyList().stream()
                .map(MacKey::getContent)
                .collect(Collectors.toList());

        return new ShortcutKeyResponseDto(
                shortcutKey.getId(),
                shortcutKey.getExplanation(),
                shortcutKey.getDetailExplanation(),
                shortcutKey.getCategory().getCategoryName(),
                windowKeyContents,
                macKeyContents
        );
    }

}
