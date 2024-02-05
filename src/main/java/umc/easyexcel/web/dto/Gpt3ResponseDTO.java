package umc.easyexcel.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

import java.awt.*;
import java.time.LocalDate;

public class Gpt3ResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChatResultDTO{
        String id;
        String object;
        LocalDate created;
        String model;
        List<ChoiceDTO.choice> choices;
    }
}
