package umc.easyexcel.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FeatureFunctions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "frequent_feature_id")
    private FrequentFeature frequentFeature;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String functions;
}
