package umc.easyexcel.converter;

import umc.easyexcel.domain.mapping.FunctionsExample;
import umc.easyexcel.web.dto.FunctionsExampleResponseDTO;
import umc.easyexcel.web.dto.FunctionsExampleResponseDTO.ExampleExplanationDTO;
import umc.easyexcel.web.dto.FunctionsExampleResponseDTO.ExampleImgDTO;
import umc.easyexcel.web.dto.FunctionsExampleResponseDTO.ExampleTipDTO;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionsExampleConverter {
    public static FunctionsExampleResponseDTO.FunctionsExampleDTO functionsExampleDTO(FunctionsExample functionsExample) {
        List<ExampleExplanationDTO> explanations = functionsExample.getExampleExplanationList().stream()
                .map(explanation -> new ExampleExplanationDTO(explanation.getId(), explanation.getExplanation()))
                .collect(Collectors.toList());

        List<ExampleTipDTO> tips = functionsExample.getExampleTipList().stream()
                .map(tip -> new ExampleTipDTO(tip.getId(), tip.getContent()))
                .collect(Collectors.toList());

        List<ExampleImgDTO> images = functionsExample.getExampleImgList().stream()
                .map(image -> new ExampleImgDTO(image.getId(), image.getUrl()))
                .collect(Collectors.toList());

        return FunctionsExampleResponseDTO.FunctionsExampleDTO.builder()
                .id(functionsExample.getId())
                .title(functionsExample.getTitle())
                .question(functionsExample.getQuestion())
                .exampleExplanationDTOList(explanations)
                .exampleTipDTOList(tips)
                .exampleImgDTOList(images)
                .build();
    }

    public static FunctionsExampleResponseDTO.FunctionsExampleListDTO functionsExampleListDTO(List<FunctionsExample> functionsExampleList, Long functionId){

        List<FunctionsExampleResponseDTO.FunctionsExampleDTO> functionsExampleDTOList = functionsExampleList.stream()
                .map(FunctionsExampleConverter::functionsExampleDTO).collect(Collectors.toList());

        return FunctionsExampleResponseDTO.FunctionsExampleListDTO.builder()
                .functionsExampleDTOList(functionsExampleDTOList)
                .listSize(functionsExampleDTOList.size())
                .functionId(functionId)
                .build();
    }

}
