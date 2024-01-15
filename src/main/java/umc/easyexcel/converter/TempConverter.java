package umc.easyexcel.converter;

import umc.easyexcel.web.dto.TempResponse;

public class TempConverter {

    public static TempResponse.TempTestDTO toTempTestDTO() {
        // 빌더 패턴으로 만들어진 객체
        return TempResponse.TempTestDTO.builder()
                .testString("This is Test!")
                .build();
    }

    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag) {
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
