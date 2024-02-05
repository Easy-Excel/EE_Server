package umc.easyexcel.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.easyexcel.domain.common.BaseEntity;
import umc.easyexcel.domain.enums.ShortcutKeyCategory;

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

    @Column(nullable = false, columnDefinition = "VARCHAR(20)")
    private String explanation;

    @Column(nullable = false, columnDefinition = "VARCHAR(20)")
    private String detailExplanation;

    @Enumerated(EnumType.STRING)
    private ShortcutKeyCategory category;

    //양방향 매핑
    @OneToMany(mappedBy = "shortcutKey", cascade = CascadeType.ALL)
    private List<MacKey> macKeyList = new ArrayList<>();

    @OneToMany(mappedBy = "shortcutKey", cascade = CascadeType.ALL)
    private List<WindowKey> windowKeys = new ArrayList<>();

}