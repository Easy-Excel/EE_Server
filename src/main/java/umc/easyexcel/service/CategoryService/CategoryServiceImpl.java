package umc.easyexcel.service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.easyexcel.converter.CategoryConverter;
import umc.easyexcel.domain.Functions;
import umc.easyexcel.repository.CategoryRepository;
import umc.easyexcel.web.dto.CategoryResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponseDTO.InquiryDTO> getFunctionsByCategory(String category) {
        List<Functions> functions = categoryRepository.getFunctionsByCategory(category);

        return functions.stream()
                .map(CategoryConverter::toInquiryDTO)
                .collect(Collectors.toList());
    }
}
