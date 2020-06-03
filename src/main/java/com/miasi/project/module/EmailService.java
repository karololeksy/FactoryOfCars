package com.miasi.project.module;

import com.miasi.project.model.CarOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    @Qualifier("getJavaMailSender")
    @Autowired
    public JavaMailSender emailSender;


    public void sendOrder(CarOrder carOrder) {
        String to = "212356@edu.p.lodz.pl";
        String subject = "Zamowienie czesci dla Fabryki Samochodow";
        String text = "Silnik o numerze: " + carOrder.getEngineId() + "\n"
                + "Skrzynia biegów o numerze: " + carOrder.getTransmissionId() + "\n"
                + "Kola o numerze: " + carOrder.getTiresId() + "\n"
                + "Farba o numerze: " + carOrder.getPaintId() + "\n"
                + "Dziękujemy!";
        sendMessage(to,subject,text);
    }


    private void sendMessage(String to, String subject, String text) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo("212356@edu.p.lodz.pl");
    message.setSubject(subject);
    message.setText(text);
    emailSender.send(message);
    }
}
