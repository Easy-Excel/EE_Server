package umc.easyexcel.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.easyexcel.domain.ExampleExplanation;
import umc.easyexcel.domain.ExampleImg;
import umc.easyexcel.domain.ExampleTip;
import umc.easyexcel.domain.Functions;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FunctionsExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "function_id")
    private Functions functions;

    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String title;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String question;

    //양방향 매핑
    @OneToMany(mappedBy = "functionsExample", cascade = CascadeType.ALL)
    private List<ExampleExplanation> exampleExplanationList = new ArrayList<>();

    @OneToMany(mappedBy = "functionsExample", cascade = CascadeType.ALL)
    private List<ExampleImg> exampleImgList = new ArrayList<>();

    @OneToMany(mappedBy = "functionsExample", cascade = CascadeType.ALL)
    private List<ExampleTip> exampleTipList = new ArrayList<>();

}
