package umc.easyexcel.converter;

import umc.easyexcel.domain.Feedback;
import umc.easyexcel.web.dto.FeedbackRequestDTO;
import umc.easyexcel.web.dto.FeedbackResponseDTO;

import java.time.LocalDateTime;

public class FeedbackConverter {

    public static FeedbackResponseDTO.SendResultDTO toSendResultDTO(Feedback feedback){
        return FeedbackResponseDTO.SendResultDTO.builder()
                .feedbackId(feedback.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Feedback toFeedback(FeedbackRequestDTO.SendDTO request){
        return Feedback.builder()
                .email(request.getEmail())
                .content(request.getContent())
                .build();
    }
}
