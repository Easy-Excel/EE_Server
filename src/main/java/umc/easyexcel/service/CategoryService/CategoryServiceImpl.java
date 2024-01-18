package umc.easyexcel.service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.easyexcel.domain.Functions;
import umc.easyexcel.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public List<Functions> getFunctionsByCategory(String category) {
        return categoryRepository.findByCategory(category);
    }
}
