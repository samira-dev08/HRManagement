package com.company.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String fromMail;

    public void sendmail(String mail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setSubject("Basvurunuz görüldü!");
        simpleMailMessage.setText("Hörmətli namizəd,\n" +
                "Şirkətimizə və vakansiyaya göstərdiyiniz marağa görə təşəkkür edirik.\n" +
                "CV-niz vakansiyanın tələblərinə uyğun dəyərləndiriləcək.\n" +
                "Uyğun olduğunuz təqdirdə, sizə geridönüş edəcəyik.\n" +
                "Uyğun olmadığınız təqdirdə isə, qətiyyən ruhdan düşməyin.\n" +
                "Sadəcə o gün bu gün deyil, bu qədər :)");
        simpleMailMessage.setTo(mail);

        mailSender.send(simpleMailMessage);
    }
}
