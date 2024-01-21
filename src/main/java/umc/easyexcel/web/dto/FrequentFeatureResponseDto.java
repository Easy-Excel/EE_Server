package umc.easyexcel.web.dto;

import lombok.*;

import java.util.*;

@Getter
@NoArgsConstructor
@Builder
public class FrequentFeatureResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FrequentFeatureDTO {
        private Long frequentFeatureId;
        private String name;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FrequentFeatureDetailDTO {
        private Long frequentFeatureId;
        private String name;
        private String explanation;
        private List<String> featureCharacteristicList;
        private List<String> featureFunctionsList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FrequentFeatureListDTO {
        private List<FrequentFeatureDTO> frequentFeatures;
        private Integer listSize;
    }

}
