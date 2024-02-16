package umc.easyexcel.service.MailService;


import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.core.io.*;
import org.springframework.mail.*;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.util.*;
import umc.easyexcel.domain.*;

import java.io.*;
import java.nio.charset.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {

    private final JavaMailSender emailSender;

    @Override
    @Transactional
    public void sendFeedbackNotification(Feedback feedback) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(feedback.getEmail());
        message.setTo("easyexcel2024@gmail.com");
        message.setSubject("[Easy-Excel] 📧 새로운 피드백이 도착했습니다!");
        String emailContent = getEmailContent(feedback);
        message.setText(emailContent);
        try {
            emailSender.send(message);
            log.info("피드백 알림 메일 전송 완료");
        } catch (MailException e) {
            log.error("피드백 알림 메일 전송 중 오류 발생", e);
            throw new RuntimeException("피드백 알림 메일 전송 중 오류 발생", e);
        }

    }

    private String getEmailContent(Feedback feedback) {
        try {
            ClassPathResource resource = new ClassPathResource("email-template.txt");
            byte[] contentBytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
            String emailTemplate = new String(contentBytes, StandardCharsets.UTF_8);

            emailTemplate = emailTemplate.replace("{email}", feedback.getEmail());
            emailTemplate = emailTemplate.replace("{content}", feedback.getContent());

            return emailTemplate;
        } catch (IOException e) {
            log.error("이메일 템플릿 파일을 읽어오는 도중 오류 발생", e);
            return "";
        }
    }

}
