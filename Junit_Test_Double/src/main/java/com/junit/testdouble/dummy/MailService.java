package com.junit.testdouble.dummy;

public class MailService {
    private final MailSender mailSender;

    public MailService(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(String mailAddress){
        mailSender.send(mailAddress);
    }
}
