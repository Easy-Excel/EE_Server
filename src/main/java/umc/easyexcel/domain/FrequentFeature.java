package umc.easyexcel.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.easyexcel.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FrequentFeature extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String explanation;

    //양방향 매핑
    @OneToMany(mappedBy = "frequentFeature", cascade = CascadeType.ALL)
    private List<FeatureCharacteristic> featureCharacteristicList = new ArrayList<>();

    @OneToMany(mappedBy = "frequentFeature", cascade = CascadeType.ALL)
    private List<FeatureFunctions> featureFunctionsList = new ArrayList<>();
}