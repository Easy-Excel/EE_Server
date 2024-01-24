package umc.easyexcel.service.FunctionsExampleService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.easyexcel.apiPayload.code.status.ErrorStatus;
import umc.easyexcel.apiPayload.exception.handler.FunctionsHandler;
import umc.easyexcel.domain.mapping.FunctionsExample;
import umc.easyexcel.repository.FunctionsExampleRepository;
import umc.easyexcel.repository.FunctionsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FunctionsExampleServiceImpl implements FunctionsExampleService{

    private final FunctionsExampleRepository functionsExampleRepository;
    private final FunctionsRepository functionsRepository;

    @Override
    public List<FunctionsExample> getFunctionsExampleList(Long functionId) {

        if (!functionIdExists(functionId)) {
            throw new FunctionsHandler(ErrorStatus.FUNCTION_NOT_FOUND);
        }

        List<FunctionsExample> functionsExampleList = functionsExampleRepository.findByFunctionsId(functionId);

        return functionsExampleList;
    }

    private boolean functionIdExists(Long functionId) {
        return functionsRepository.existsById(functionId);
    }

}
