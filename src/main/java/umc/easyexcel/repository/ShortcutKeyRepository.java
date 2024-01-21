package umc.easyexcel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.easyexcel.domain.*;
import umc.easyexcel.domain.enums.*;

import java.util.*;

public interface ShortcutKeyRepository extends JpaRepository<ShortcutKey, Long> {

    List<ShortcutKey> findByCategory(ShortcutKeyCategory category);

    List<ShortcutKey> findByExplanationContainingIgnoreCaseOrDetailExplanationContainingIgnoreCase(String explanation, String detailExplanation);

}
