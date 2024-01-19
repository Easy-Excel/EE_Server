package umc.easyexcel.service.FrequentFeatureService;

import umc.easyexcel.domain.*;

import java.util.*;

public interface FrequentFeatureQueryService {
    List<FrequentFeature> getAllFrequentFeatures();
    FrequentFeature getFrequentFeatureById(Long frequentFeatureId);
}
