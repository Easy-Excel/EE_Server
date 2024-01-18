package umc.easyexcel.service.CategoryService;

import umc.easyexcel.web.dto.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDTO.InquiryDTO> getFunctionsByCategory(String category);
}
