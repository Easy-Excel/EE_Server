package umc.easyexcel.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.easyexcel.domain.Function;
import umc.easyexcel.domain.Value;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FunctionValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "function_id")
    private Function function;

    // 단방향 일대일 매핑
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "value_id")
    private Value value;

    private Integer order;
}
