package umc.easyexcel.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.easyexcel.apiPayload.ApiResponse;
import umc.easyexcel.converter.FeedbackConverter;
import umc.easyexcel.domain.Feedback;
import umc.easyexcel.service.FeedbackService.FeedbackService;
import umc.easyexcel.web.dto.FeedbackRequestDTO;
import umc.easyexcel.web.dto.FeedbackResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/etc")
public class FeedbackRestController {

    private final FeedbackService feedbackService;

    @PostMapping("/feedback")
    public ApiResponse<FeedbackResponseDTO.SendResultDTO> send(@RequestBody @Valid FeedbackRequestDTO.SendDTO request){
        Feedback feedback = feedbackService.sendFeedback(request);
        return ApiResponse.onSuccess(FeedbackConverter.toSendResultDTO(feedback));
    }
}
