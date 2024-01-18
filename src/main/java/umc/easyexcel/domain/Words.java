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
public class Words extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String content;

    @OneToMany(mappedBy = "words", cascade = CascadeType.ALL)
    private List<SimilarWords> SimilarWordsList = new ArrayList<>();
}
