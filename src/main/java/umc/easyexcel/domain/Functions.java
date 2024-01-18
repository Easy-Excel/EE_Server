package umc.easyexcel.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.easyexcel.domain.common.BaseEntity;
import umc.easyexcel.domain.mapping.FunctionsValue;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Functions extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(40)")
    private String name;

    @Column(columnDefinition = "VARCHAR(255)")
    private String explanation;

    @Column(columnDefinition = "VARCHAR(30)")
    private String category;

    @Column(columnDefinition = "VARCHAR(50)")
    private String caution; // 여기도 테이블 따로 빼줘야 함. 일단 1개라고 가정하고 함

    //양방향 매핑
    @OneToMany(mappedBy = "functions", cascade = CascadeType.ALL)
    private List<FunctionsValue> functionsValueList = new ArrayList<>();

    @OneToMany(mappedBy = "functions", cascade = CascadeType.ALL)
    private List<FunctionsExample> functionsExampleList = new ArrayList<>();
}
