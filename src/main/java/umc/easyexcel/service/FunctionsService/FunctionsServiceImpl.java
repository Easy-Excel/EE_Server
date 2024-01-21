package umc.easyexcel.service.FunctionsService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.easyexcel.apiPayload.code.status.ErrorStatus;
import umc.easyexcel.apiPayload.exception.handler.FunctionsHandler;
import umc.easyexcel.domain.Functions;
import umc.easyexcel.domain.FunctionsCaution;
import umc.easyexcel.domain.mapping.FunctionsValue;
import umc.easyexcel.repository.FunctionsRepository;
import umc.easyexcel.repository.ValueRepository;
import umc.easyexcel.web.dto.FunctionsResponseDTO;
import umc.easyexcel.web.dto.ValueDTO;

import java.util.List;
import java.util.stream.Collectors;

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

        List<String> functionsCautions = functions.getFunctionsCautionList().stream()
                .map(FunctionsCaution::getCaution)
                .toList();

        List<FunctionsValue> functionsValues = functions.getFunctionsValueList();

        List<ValueDTO.getValueDTO> engAndKorList = functionsValues.stream()
                .flatMap(functionsValue -> {
                    // functionsValue에서 order 값을 가져와서 Stream을 생성
                    int order = functionsValue.getOrders();

                    return valueRepository.findById(functionsValue.getId()).stream()
                            .map(value -> ValueDTO.getValueDTO.builder()
                                    .order(order)
                                    .kor(value.getKor())
                                    .eng(value.getEng())
                                    .build());
                })
                .collect(Collectors.toList());

        return FunctionsResponseDTO.GetFunctionsDTO.builder()
                .id(functions.getId())
                .name(functions.getName())
                .explanation(functions.getExplanation())
                .caution(functionsCautions)
                .engAndKorList(engAndKorList)
                .build();
    }
}
