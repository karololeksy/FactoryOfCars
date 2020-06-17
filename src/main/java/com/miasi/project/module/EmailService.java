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
        String to = "fabrykasamochodow.miasi@gmail.com";
        String subject = "Zamowienie czesci dla Fabryki Samochodow";
        String text = "Silnik o numerze: " + carOrder.getEngineId() + "\n"
                + "Skrzynia biegów o numerze: " + carOrder.getTransmissionId() + "\n"
                + "Kola o numerze: " + carOrder.getTiresId() + "\n"
                + "Farba o numerze: " + carOrder.getPaintId() + "\n"
                + "Dziękujemy!";
        sendMessage(to, subject, text);
    }

    public void sendFailure(String email) {
        String subject = "Niepowodzenie produkcji samochodu!";
        String text = "Z przykrością informujemy, że wystąpił problem w naszym magazynie\n" +
                "Dlatego nie możemy wykonać zamówienia samochodu.\nPrzepraszamy za problem.\nTeam Audi";
        sendMessage(email, subject, text);
    }

    public void sendSuccess(String email) {
        String subject = "Realizacja zamówienia!";
        String text = "Dzień dobry,\nzamówienie zostało zrealizowane. Państwa nowy samochód czeka na odbiór w naszym salonie na uliicy Mickiewicza" +
                "\nPozdrawiamy,\nTeam Audi";
        sendMessage(email, subject, text);
    }


    private void sendMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}
