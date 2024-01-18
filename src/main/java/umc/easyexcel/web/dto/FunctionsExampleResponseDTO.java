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
        List<ExampleExplanationDTO> explanationDTOList;
        List<ExampleTipDTO> exampleTipDTOList;
        List<ExampleImageDTO> exampleImageDTOList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExampleExplanationDTO {
        Long id;
        String explanation;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExampleTipDTO {
        Long id;
        String content;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExampleImageDTO {
        Long id;
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
