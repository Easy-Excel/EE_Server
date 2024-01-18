package umc.easyexcel.service.FunctionsExampleService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.easyexcel.domain.mapping.FunctionsExample;
import umc.easyexcel.repository.FunctionsExampleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FunctionsExampleServiceImpl implements FunctionsExampleService{

    private final FunctionsExampleRepository functionsExampleRepository;

    @Override
    public List<FunctionsExample> getFunctionsExampleList(Long functionId) {
        List<FunctionsExample> functionsExampleList = functionsExampleRepository.findByFunctionsId(functionId);
        return functionsExampleList;
    }

}
