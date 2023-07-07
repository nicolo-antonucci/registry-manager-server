package com.nicoloantonucci.registrymanagerserver.controller;

import com.nicoloantonucci.registrymanagerserver.model.Registry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMailToUser(Registry registry) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(registry.getEmail());
        message.setSubject("Comunicazione anagrafica");
        message.setText("Salve " +
                registry.getName() +
                " " + registry.getSurname() +
                ",\n le comunichiamo i suoi dati registrati:\n" +
                "<b>Nome:</b> " + registry.getName() + "\n" +
                "<b>Cognome:</b> " + registry.getSurname() + "\n" +
                "<b>Indirizzo:</b> " + registry.getAddress() + "\n" +
                "<b>Località:</b> " + registry.getLocation() + "\n" +
                "<b>Città:</b> " + registry.getCity() + "\n" +
                "<b>Provincia:</b> " + registry.getProvince() + "\n" +
                "<b>Email:</b> " + registry.getEmail() + "\n" +
                "<b>Note:</b> " + registry.getNotes()
        );
        mailSender.send(message);
    }
}
