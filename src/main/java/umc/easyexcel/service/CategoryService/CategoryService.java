package umc.easyexcel.service.CategoryService;

import umc.easyexcel.domain.Functions;
import umc.easyexcel.domain.enums.FunctionCategory;

import java.util.List;

public interface CategoryService {
    List<Functions> getFunctionsByCategoryList(FunctionCategory category);
}
