package umc.easyexcel.service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.easyexcel.domain.Functions;
import umc.easyexcel.domain.enums.FunctionCategory;
import umc.easyexcel.repository.CategoryRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public List<Functions> getFunctionsByCategoryList(FunctionCategory category) {
        List<Functions> functionsByCategoryList = categoryRepository.findByCategory(category);

        // 알파벳 순으로 정렬
        List<Functions> sortedFunctions = functionsByCategoryList.stream()
                .sorted(Comparator.comparing(Functions::getName))
                .collect(Collectors.toList());

        return sortedFunctions;
    }
}
