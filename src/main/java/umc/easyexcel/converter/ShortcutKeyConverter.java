package umc.easyexcel.converter;

import umc.easyexcel.domain.*;
import umc.easyexcel.web.dto.*;

import java.util.*;
import java.util.stream.*;

public class ShortcutKeyConverter {

    public static ShortcutKeyResponseDto.ShortcutKeyDTO shortcutKeyDTO(ShortcutKey shortcutKey) {
        ShortcutKeyResponseDto.ShortcutKeyDTO dto = ShortcutKeyResponseDto.ShortcutKeyDTO.builder()
                .id(shortcutKey.getId())
                .explanation(shortcutKey.getExplanation())
                .detailExplanation(shortcutKey.getDetailExplanation())
                .build();

        if (shortcutKey.getWindowKeys() != null && !shortcutKey.getWindowKeys().isEmpty()) {
            String windowKeyString = shortcutKey.getWindowKeys().stream()
                    .map(WindowKey::getContent)
                    .collect(Collectors.joining(" + "));
            dto.setWindowKeysFromString(windowKeyString);
        }

        if (shortcutKey.getMacKeyList() != null && !shortcutKey.getMacKeyList().isEmpty()) {
            String macKeyString = shortcutKey.getMacKeyList().stream()
                    .map(MacKey::getContent)
                    .collect(Collectors.joining(" + "));
            dto.setMacKeyFromString(macKeyString);
        }

        return dto;
    }

    public static ShortcutKeyResponseDto.ShortcutKeyListDTO shortcutKeyListDTO(List<ShortcutKey> shortcutKeyList, String category) {
        List<ShortcutKeyResponseDto.ShortcutKeyDTO> shortcutKeyDTOList = shortcutKeyList.stream()
                .map(ShortcutKeyConverter::shortcutKeyDTO)
                .collect(Collectors.toList());

        return ShortcutKeyResponseDto.ShortcutKeyListDTO.builder()
                .shortcutKeyList(shortcutKeyDTOList)
                .listSize(shortcutKeyDTOList.size())
                .categoryType(category)
                .build();
    }
}
