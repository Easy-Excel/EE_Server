package umc.easyexcel.web.dto;

import lombok.*;

import java.util.*;

@Getter
@AllArgsConstructor
public class ShortcutKeyResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ShortcutKeyDTO {
        Long id;
        String explanation;
        String detailExplanation;
        List<String> windowKey;
        List<String> macKey;

        public void setWindowKeysFromString(String windowKeysString) {
            this.windowKey = Arrays.asList(windowKeysString.split("\\s*\\+\\s*"));
        }

        public void setMacKeyFromString(String macKeyString) {
            this.macKey = Arrays.asList(macKeyString.split("\\s*\\+\\s*"));
        }
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ShortcutKeyListDTO {
        List<ShortcutKeyDTO> shortcutKeyList;
        Integer listSize;
        String categoryType;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ShortcutKeySearchDTO{
        List<ShortcutKeyDTO> searchResults;
        Integer resultSize;
        String searchKeyword;
    }
}

