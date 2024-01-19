package umc.easyexcel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.easyexcel.domain.mapping.FunctionsValue;

import java.util.List;

public interface FunctionsValueRepository extends JpaRepository<FunctionsValue, Long> {
    List<FunctionsValue> findByValueId(Long valueId);
}
