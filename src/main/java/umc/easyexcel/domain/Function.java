package umc.easyexcel.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.easyexcel.domain.common.BaseEntity;
import umc.easyexcel.domain.mapping.FunctionValue;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Function extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String explanation;

    private String category;

    private String caution;

    //양방향 매핑
    @OneToMany(mappedBy = "function", cascade = CascadeType.ALL)
    private List<FunctionValue> functionValueList = new ArrayList<>();

    @OneToMany(mappedBy = "function", cascade = CascadeType.ALL)
    private List<FunctionExample> functionExampleList = new ArrayList<>();
}
