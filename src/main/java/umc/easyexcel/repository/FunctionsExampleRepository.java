package umc.easyexcel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.easyexcel.domain.mapping.FunctionsExample;

import java.util.List;

public interface FunctionsExampleRepository extends JpaRepository<FunctionsExample, Long> {
    List<FunctionsExample> findByFunctionsId(Long functionId);
}
