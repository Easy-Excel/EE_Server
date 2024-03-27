package umc.easyexcel.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.easyexcel.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Feedback extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String email;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

}