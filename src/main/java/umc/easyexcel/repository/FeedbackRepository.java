package umc.easyexcel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.easyexcel.domain.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
