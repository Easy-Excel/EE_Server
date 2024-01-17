package umc.easyexcel.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import umc.easyexcel.apiPayload.exception.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

@Getter
@AllArgsConstructor
public enum ShortcutKeyCategory {
    FILE_EXECUTION("파일 실행"),
    GENERAL("일반"),
    SHEET_EDITING("시트 편집"),
    INTEGRATED_DOCUMENT_EDITING("통합문서 편집"),
    MOVE("이동");

    private static final Map<String, ShortcutKeyCategory> categoryMap = Stream.of(values())
            .collect(Collectors.toMap(ShortcutKeyCategory::getCategoryName, Function.identity()));

    @JsonValue
    private final String categoryName;

    @JsonCreator
    public static ShortcutKeyCategory resolve(String categoryName) {
        return Optional.ofNullable(categoryMap.get(categoryName))
                .orElseThrow(() -> new EasyExcelException(ErrorCode.VALUE_NOT_IN_OPTION));
    }
}
