package umc.easyexcel.service.FunctionsService;

import umc.easyexcel.web.dto.FunctionsResponseDTO;

public interface FunctionsService {
    public FunctionsResponseDTO.GetFunctionsDTO getFunctionsByFunctionId(Long functionId);
}
