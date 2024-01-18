package umc.easyexcel.service.CategoryService;

import umc.easyexcel.domain.Functions;
import java.util.List;

public interface CategoryService {
    List<Functions> getFunctionsByCategoryList(String category);
}
