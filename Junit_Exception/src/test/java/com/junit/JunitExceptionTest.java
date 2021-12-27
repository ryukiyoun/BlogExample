package com.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JunitExceptionTest {

    @Test
    public void NullPointException(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            List<String> temp = null;

            temp.get(0);
        });
    }

    @Test
    public void SupperClassRuntimeException(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            List<String> temp = null;

            temp.get(0);
        });
    }
}
