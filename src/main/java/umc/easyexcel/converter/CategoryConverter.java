package umc.easyexcel.converter;

import umc.easyexcel.domain.Functions;
import umc.easyexcel.web.dto.CategoryResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryConverter {

    public static CategoryResponseDTO.InquiryDTO inquiryDTO(Functions functions) {
        return CategoryResponseDTO.InquiryDTO.builder()
                .id(functions.getId())
                .name(functions.getName())
                .build();
    }

    public static CategoryResponseDTO.InquiryListDTO inquiryListDTO(List<Functions> functionsByCategoryList, String category){

        List<CategoryResponseDTO.InquiryDTO> inquiryDTOList = functionsByCategoryList.stream()
                .map(CategoryConverter::inquiryDTO).collect(Collectors.toList());

        return CategoryResponseDTO.InquiryListDTO.builder()
                .inquiryList(inquiryDTOList)
                .listSize(inquiryDTOList.size())
                .categoryType(category)
                .build();
    }
}
