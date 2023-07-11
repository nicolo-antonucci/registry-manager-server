package com.nicoloantonucci.registrymanagerserver.controller;

import com.nicoloantonucci.registrymanagerserver.model.Registry;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public Boolean sendMailToUser(Registry registry) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            message.setFrom(new InternetAddress("nicolo.testsmtp@gmail.com"));
            message.setRecipients(MimeMessage.RecipientType.TO, registry.getEmail());
            message.setSubject("Comunicazione anagrafica");
            message.setContent("Salve " +
                    registry.getName() +
                    " " + registry.getSurname() +
                    ",\n le comunichiamo i suoi dati registrati:<br>" +
                    "<b>Nome:</b> " + registry.getName() + "<br>" +
                    "<b>Cognome:</b> " + registry.getSurname() + "<br>" +
                    "<b>Indirizzo:</b> " + (registry.getAddress() != null ? registry.getAddress() : "nessun dato") + "<br>" +
                    "<b>Località:</b> " + (registry.getLocation() != null ? registry.getLocation() : "nessun dato") + "<br>" +
                    "<b>Città:</b> " + (registry.getCity() != null ? registry.getCity() : "nessun dato") + "<br>" +
                    "<b>Provincia:</b> " + (registry.getProvince() != null ? registry.getProvince() : "nessun dato") + "<br>" +
                    "<b>Email:</b> " + registry.getEmail() + "<br>" +
                    "<b>Note:</b> " + (registry.getNotes() != null ? registry.getNotes() : "nessun dato"), "text/html; charset=utf-8"
            );
            mailSender.send(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
