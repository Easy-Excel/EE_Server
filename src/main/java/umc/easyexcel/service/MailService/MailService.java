package umc.easyexcel.service.MailService;

import umc.easyexcel.domain.*;

public interface MailService {
    void sendFeedbackNotification(Feedback feedback);
}