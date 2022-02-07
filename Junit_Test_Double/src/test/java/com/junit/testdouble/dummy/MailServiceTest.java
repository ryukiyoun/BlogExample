package com.junit.testdouble.dummy;

import org.junit.jupiter.api.Test;

class MailServiceTest {

    @Test
    void sendMail() {
        MailService mailService = new MailService(new DummyMailSender());

        mailService.sendMail("address");
    }

    public class DummyMailSender implements MailSender{
        @Override
        public void send(String mailAddress) {
        }
    }
}