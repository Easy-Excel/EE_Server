package umc.easyexcel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.easyexcel.domain.*;

import java.util.*;

public interface SimilarWordsRepository extends JpaRepository<SimilarWords, Long> {
    List<SimilarWords> findByContentContaining(String content);
}
