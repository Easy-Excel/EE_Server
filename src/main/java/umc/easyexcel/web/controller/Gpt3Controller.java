package umc.easyexcel.web.controller;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.easyexcel.apiPayload.ApiResponse;
import umc.easyexcel.web.dto.Gpt3RequestDTO;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/gpt3")
public class Gpt3Controller {


    @Value("${OPENAI_API_KEY}")
    private String openaiApiKey;

    @PostMapping("/question")
    public ApiResponse<?> sendQuestion(@RequestBody @Valid Gpt3RequestDTO.ChatQuestionDTO question) {
        OpenAiService service = new OpenAiService(openaiApiKey);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(question.getPrompt())
                .model("babbage-002")
                .echo(false)
                .build();
        return ApiResponse.onSuccess(service.createCompletion(completionRequest).getChoices());
    }
}
