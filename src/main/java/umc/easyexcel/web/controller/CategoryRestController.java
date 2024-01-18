package umc.easyexcel.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.easyexcel.apiPayload.ApiResponse;
import umc.easyexcel.domain.Functions;
import umc.easyexcel.service.CategoryService.CategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/functions")
public class CategoryRestController {

    private final CategoryService categoryService;

    @GetMapping("/category")
    public ApiResponse<List<Functions>> getFunctionsByCategory(@RequestParam("type") String category) {
        List<Functions> functions = categoryService.getFunctionsByCategory(category);
        return ApiResponse.onSuccess(functions);
    }
}
