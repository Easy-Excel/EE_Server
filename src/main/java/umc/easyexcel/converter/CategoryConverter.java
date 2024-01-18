package umc.easyexcel.converter;

import umc.easyexcel.domain.Functions;
import umc.easyexcel.web.dto.CategoryResponseDTO;

public class CategoryConverter {

    public static CategoryResponseDTO.InquiryDTO toInquiryDTO(Functions functions) {
        return CategoryResponseDTO.InquiryDTO.builder()
                .id(functions.getId())
                .name(functions.getName())
                .category(functions.getCategory())
                .build();
    }
}
