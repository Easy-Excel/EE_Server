package umc.easyexcel.converter;

import umc.easyexcel.domain.*;
import umc.easyexcel.web.dto.*;

import java.util.stream.*;

public class FrequentFeatureConverter {

    public static FrequentFeatureResponseDto.FrequentFeatureDTO toResponseSimpleDTO(FrequentFeature frequentFeature) {
        return FrequentFeatureResponseDto.FrequentFeatureDTO.builder()
                .frequentFeatureId(frequentFeature.getId())
                .name(frequentFeature.getName())
                .build();
    }

    public static FrequentFeatureResponseDto.FrequentFeatureDetailDTO toResponseDetailedDTO(FrequentFeature frequentFeature) {
        return FrequentFeatureResponseDto.FrequentFeatureDetailDTO.builder()
                .frequentFeatureId(frequentFeature.getId())
                .name(frequentFeature.getName())
                .explanation(frequentFeature.getExplanation())
                .featureCharacteristicList(frequentFeature.getFeatureCharacteristicList().stream()
                        .map(FeatureCharacteristic::getContent)
                        .collect(Collectors.toList()))
                .featureFunctionsList(frequentFeature.getFeatureFunctionsList().stream()
                        .map(FeatureFunctions::getFunctions)
                        .collect(Collectors.toList()))
                .build();
    }

}

