package com.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JunitExceptionTest {

    @Test
    public void NullPointException(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            List<String> list = null;

            list.get(0);
        });
    }

    @Test
    public void SupperClassRuntimeException(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            List<String> list = null;

            list.get(0);
        });

        Assertions.assertThrows(Exception.class, () -> {
            List<String> list = null;

            list.get(0);
        });

        Assertions.assertThrows(Throwable.class, () -> {
            List<String> list = null;

            list.get(0);
        });
    }

    @Test
    public void NonNullPointExceptionMessage(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            List<String> list = new ArrayList<>();
            list.add("test1");

            list.get(0);
        }, "예외가 발생하지 않았습니다.");
    }
}
