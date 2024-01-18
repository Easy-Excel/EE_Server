package umc.easyexcel.service.FunctionsService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.easyexcel.domain.Functions;
import umc.easyexcel.repository.FunctionsRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FunctionsQueryServiceImpl implements FunctionsQueryService{

    private final FunctionsRepository functionsRepository;

    @Override
    public List<Functions> getFunctionsList(String firstSorting, String lastSorting) {

        List<Functions> functionsList = functionsRepository.findNameBySorting(firstSorting,lastSorting);

        return functionsList;
    }
}
