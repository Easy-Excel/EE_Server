package umc.easyexcel.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class FunctionsExampleResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FunctionsExampleDTO {
        Long id;
        String question;
        String answer;
        List<ExampleExplanationDTO> exampleExplanationDTOList;
        List<ExampleTipDTO> exampleTipDTOList;
        List<ExampleImgDTO> exampleImgDTOList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExampleExplanationDTO {
        Long explanationId;
        String explanation;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExampleTipDTO {
        Long tipId;
        String content;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExampleImgDTO {
        Long imgId;
        String url;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FunctionsExampleListDTO{
        List<FunctionsExampleDTO> functionsExampleDTOList;
        Integer listSize;
        Long functionId;
    }

}
