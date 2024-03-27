package umc.easyexcel.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.easyexcel.domain.mapping.FunctionsExample;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ExampleTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "functions_example_id")
    private FunctionsExample functionsExample;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String content;

}