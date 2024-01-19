package umc.easyexcel.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.easyexcel.domain.common.BaseEntity;
import umc.easyexcel.domain.mapping.FunctionsExample;
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

    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String name;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String explanation;

    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String category;

    //양방향 매핑
    @OneToMany(mappedBy = "functions", cascade = CascadeType.ALL)
    private List<FunctionsValue> functionsValueList = new ArrayList<>();

    @OneToMany(mappedBy = "functions", cascade = CascadeType.ALL)
    private List<FunctionsExample> functionsExampleList = new ArrayList<>();

    @OneToMany(mappedBy = "functions", cascade = CascadeType.ALL)
    private List<FunctionsCaution> functionsCautionList = new ArrayList<>();

}

