package com.junit.testdouble.dummy;

public class LiveMailSender implements MailSender{
    @Override
    public void send(String mailAddress) {
        System.out.println("메일 주소" + mailAddress + "로 메일을 전송 하였습니다.");
    }
}
