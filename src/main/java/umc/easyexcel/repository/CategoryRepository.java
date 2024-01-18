package umc.easyexcel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.easyexcel.domain.Functions;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Functions, Long> {
    List<Functions> getFunctionsByCategory(String category);
}
