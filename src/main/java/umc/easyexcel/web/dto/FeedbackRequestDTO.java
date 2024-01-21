package umc.easyexcel.web.dto;

import lombok.Getter;

public class FeedbackRequestDTO {

    @Getter
    public static class SendDTO{
        String email;
        String content;
    }
}
