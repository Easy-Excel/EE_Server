package umc.easyexcel.domain;

import jakarta.persistence.*;
import lombok.*;

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

    private String question;

    private String answer;

    //양방향 매핑
    @OneToMany(mappedBy = "functionsExample", cascade = CascadeType.ALL)
    private List<ExampleExplanation> exampleExplanationList = new ArrayList<>();

    @OneToMany(mappedBy = "functionsExample", cascade = CascadeType.ALL)
    private List<ExampleImg> exampleImgList = new ArrayList<>();

    @OneToMany(mappedBy = "functionsExample", cascade = CascadeType.ALL)
    private List<ExampleTip> exampleTipList = new ArrayList<>();

}
