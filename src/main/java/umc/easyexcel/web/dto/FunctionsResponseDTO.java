package umc.easyexcel.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class FunctionsResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetFunctionsDTO{
        Long id;
        String name;
        String explanation;
        String caution;
        List<ValueDTO.getValueDTO> engAndKorList;
    }
}
