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

    public static FunctionsResponseDTO.FunctionsSortingListDTO functionsListDTO(List<Functions> functionsList,
                                                                         String firstSorting,String lastSorting){

        List<FunctionsResponseDTO.FunctionsDTO> functionsDTOList = functionsList.stream()
                .map(FunctionsConverter::functionsDTO).collect(Collectors.toList());

        String sortingType = String.format("%s ~ %s", firstSorting.toUpperCase(), lastSorting.toUpperCase());
        // A ~ H 처럼 형식 변환

        return FunctionsResponseDTO.FunctionsSortingListDTO.builder()
                .functionsSortingList(functionsDTOList)
                .listSize(functionsDTOList.size())
                .sortingType(sortingType)
                .build();
    }

    public static FunctionsResponseDTO.FunctionsSearchListDTO functionsSerachListDTO(List<Functions> functionsList,
                                                                                 String keyword){

        List<FunctionsResponseDTO.FunctionsDTO> functionsSerachDTOList = functionsList.stream()
                .map(FunctionsConverter::functionsDTO).collect(Collectors.toList());

        return FunctionsResponseDTO.FunctionsSearchListDTO.builder()
                .functionsSearchList(functionsSerachDTOList)
                .listSize(functionsSerachDTOList.size())
                .searchKeyword(keyword)
                .build();
    }

}
