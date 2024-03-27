package umc.easyexcel.web.dto;

import lombok.*;

public class ValueDTO {

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getValueDTO{
        Integer order;
        String eng;
        String kor;
    }
}
