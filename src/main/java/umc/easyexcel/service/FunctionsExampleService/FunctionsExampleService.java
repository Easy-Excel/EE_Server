package umc.easyexcel.service.FunctionsExampleService;

import umc.easyexcel.domain.mapping.FunctionsExample;

import java.util.List;

public interface FunctionsExampleService {
    List<FunctionsExample> getFunctionsExampleList(Long functionId);
}
