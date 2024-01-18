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
public class ShortcutKey extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String explanation;

    private String detailExplanation;

    private String category;

    //양방향 매핑
    @OneToMany(mappedBy = "shortcutKey", cascade = CascadeType.ALL)
    private List<MacKey> macKeyList = new ArrayList<>();

    @OneToMany(mappedBy = "shortcutKey", cascade = CascadeType.ALL)
    private List<WindowKey> windowKeys = new ArrayList<>();

}