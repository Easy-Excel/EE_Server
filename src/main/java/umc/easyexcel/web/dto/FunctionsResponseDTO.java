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
        List<String> caution;
        List<ValueDTO.getValueDTO> engAndKorList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FunctionsDTO{
        Long functionId;
        String name;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FunctionsSortingListDTO{
        List<FunctionsDTO> functionsSortingList;
        Integer listSize;
        String sortingType;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FunctionsSearchListDTO{
        List<FunctionsDTO> functionsSearchList;
        Integer listSize;
        String searchKeyword;
    }

}
