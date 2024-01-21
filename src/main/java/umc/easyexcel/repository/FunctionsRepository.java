package umc.easyexcel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import umc.easyexcel.domain.Functions;

import java.util.List;

public interface FunctionsRepository extends JpaRepository<Functions,Long> {

    @Query("SELECT f FROM Functions f WHERE LOWER(LEFT(f.name, 1)) BETWEEN :firstSorting AND :lastSorting ORDER BY LOWER(f.name)")
    List<Functions> findNameBySorting(String firstSorting, String lastSorting);

    List<Functions> findByNameContainingOrderByNameAsc(String keyword);
}
