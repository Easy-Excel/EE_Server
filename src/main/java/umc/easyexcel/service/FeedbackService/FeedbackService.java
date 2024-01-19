package umc.easyexcel.service.FeedbackService;

import umc.easyexcel.domain.Feedback;
import umc.easyexcel.web.dto.FeedbackRequestDTO;

public interface FeedbackService {
    public Feedback sendFeedback(FeedbackRequestDTO.SendDTO request);
}
