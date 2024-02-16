package umc.easyexcel.web.controller;

import jakarta.mail.*;
import jakarta.validation.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;
import umc.easyexcel.apiPayload.*;
import umc.easyexcel.converter.*;
import umc.easyexcel.domain.*;
import umc.easyexcel.service.FeedbackService.*;
import umc.easyexcel.service.MailService.*;
import umc.easyexcel.web.dto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/etc")
public class FeedbackRestController {

    private final FeedbackService feedbackService;
    private final MailService mailService;

    @PostMapping("/feedback")
    public ApiResponse<FeedbackResponseDTO.SendResultDTO> send(@RequestBody @Valid FeedbackRequestDTO.SendDTO request) throws MessagingException {
        Feedback feedback = feedbackService.sendFeedback(request);
        mailService.sendFeedbackNotification(feedback);
        return ApiResponse.onSuccess(FeedbackConverter.toSendResultDTO(feedback));
    }
}
