package umc.easyexcel.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.easyexcel.domain.Functions;
import umc.easyexcel.domain.Value;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FunctionsValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "functions_id")
    private Functions functions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "value_id")
    private Value value;

    private Integer orders;
}