package umc.easyexcel.service.FunctionsService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.easyexcel.apiPayload.code.status.ErrorStatus;
import umc.easyexcel.apiPayload.exception.handler.FunctionsHandler;
import umc.easyexcel.converter.FunctionsConverter;
import umc.easyexcel.domain.Functions;
import umc.easyexcel.repository.FunctionsRepository;
import umc.easyexcel.repository.ValueRepository;
import umc.easyexcel.web.dto.FunctionsResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FunctionsServiceImpl implements FunctionsService {

    private final FunctionsRepository functionsRepository;
    private final ValueRepository valueRepository;

    @Override
    @Transactional
    public FunctionsResponseDTO.GetFunctionsDTO getFunctionsByFunctionId(Long functionId){
        Functions functions = functionsRepository.findById(functionId)
                .orElseThrow(() -> new FunctionsHandler(ErrorStatus.FUNCTION_NOT_FOUND));



        return FunctionsConverter.getFunctionsResultDTO(functions, valueRepository);
    }
}
