package umc.easyexcel.converter;
import umc.easyexcel.domain.Functions;
import umc.easyexcel.domain.FunctionsCaution;
import umc.easyexcel.domain.mapping.FunctionsValue;
import umc.easyexcel.repository.ValueRepository;
import umc.easyexcel.web.dto.FunctionsResponseDTO;
import umc.easyexcel.web.dto.ValueDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionsConverter {



    public static FunctionsResponseDTO.GetFunctionsDTO getFunctionsResultDTO(Functions functions, ValueRepository valueRepository){

        List<String> functionsCautions = functions.getFunctionsCautionList().stream()
                .map(FunctionsCaution::getCaution)
                .toList();

        List<FunctionsValue> functionsValues = functions.getFunctionsValueList();

        List<ValueDTO.getValueDTO> engAndKorList = functionsValues.stream()
                .flatMap(functionsValue -> {
                    // functionsValue에서 order 값을 가져와서 Stream을 생성
                    int order = functionsValue.getOrders();

                    Stream<ValueDTO.getValueDTO> getValueDTOStream = valueRepository.findById(functionsValue.getValue().getId()).stream()
                            .map(value -> ValueDTO.getValueDTO.builder()
                                    .order(order)
                                    .kor(value.getKor())
                                    .eng(value.getEng())
                                    .build());
                    return getValueDTOStream;
                })
                .collect(Collectors.toList());

        return FunctionsResponseDTO.GetFunctionsDTO.builder()
                .id(functions.getId())
                .name(functions.getName())
                .explanation(functions.getExplanation())
                .caution(functionsCautions)
                .engAndKorList(engAndKorList)
                .build();
    }

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
