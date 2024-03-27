package umc.easyexcel.service.FrequentFeatureService;

import jakarta.transaction.*;
import lombok.*;
import org.springframework.stereotype.*;
import umc.easyexcel.domain.*;
import umc.easyexcel.repository.*;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class FrequentFeatureQueryServiceImpl implements FrequentFeatureQueryService {

    private final FrequentFeatureRepository frequentFeatureRepository;

    @Override
    public List<FrequentFeature> getAllFrequentFeatures() {
        return frequentFeatureRepository.findAll();
    }

    @Override
    public FrequentFeature getFrequentFeatureById(Long frequentFeatureId) {
        return frequentFeatureRepository.findById(frequentFeatureId).orElse(null);
    }

}
