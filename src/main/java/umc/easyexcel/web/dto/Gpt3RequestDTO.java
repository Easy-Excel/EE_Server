package umc.easyexcel.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Gpt3RequestDTO {

    @Getter
    public static class ChatQuestionDTO{
        String prompt;
    }
}
