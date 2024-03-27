package umc.easyexcel.service.FeedbackService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.easyexcel.converter.FeedbackConverter;
import umc.easyexcel.domain.Feedback;
import umc.easyexcel.repository.FeedbackRepository;
import umc.easyexcel.web.dto.FeedbackRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FeedbackServiceImpl implements FeedbackService{

    private final FeedbackRepository feedbackRepository;

    @Override
    @Transactional
    public Feedback sendFeedback(FeedbackRequestDTO.SendDTO request){
        Feedback newFeedback = FeedbackConverter.toFeedback(request);
        return feedbackRepository.save(newFeedback);
    }
}
