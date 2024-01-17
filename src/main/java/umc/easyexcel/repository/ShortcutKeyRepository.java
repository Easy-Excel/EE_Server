package umc.easyexcel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.easyexcel.domain.*;

import java.util.*;

public interface ShortcutKeyRepository extends JpaRepository<ShortcutKey, Long> {

    List<ShortcutKey> findByCategory(ShortcutKeyCategory category);
}
