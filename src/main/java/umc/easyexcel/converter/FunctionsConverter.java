package umc.easyexcel.converter;

import umc.easyexcel.domain.Functions;
import umc.easyexcel.web.dto.FunctionsResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionsConverter {

    public static FunctionsResponseDTO.FunctionsDTO functionsDTO(Functions functions){
        return FunctionsResponseDTO.FunctionsDTO.builder()
                .functionId(functions.getId())
                .name(functions.getName())
                .build();
    }

    public static FunctionsResponseDTO.FunctionsListDTO functionsListDTO(List<Functions> functionsList,
                                                                         String firstSorting,String lastSorting){

        List<FunctionsResponseDTO.FunctionsDTO> functionsDTOList = functionsList.stream()
                .map(FunctionsConverter::functionsDTO).collect(Collectors.toList());

        String sortingType = String.format("%s ~ %s", firstSorting.toUpperCase(), lastSorting.toUpperCase());
        // A ~ H 처럼 형식 변환

        return FunctionsResponseDTO.FunctionsListDTO.builder()
                .functionsList(functionsDTOList)
                .listSize(functionsDTOList.size())
                .sortingType(sortingType)
                .build();
    }
}
