package umc.easyexcel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.easyexcel.domain.Value;

import java.util.List;

public interface ValueRepository extends JpaRepository<Value, Long> {
    List<Value> findAllById(Long valueId);
}
