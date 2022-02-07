package com.junit.testdouble.teststub;

import com.junit.testdouble.common.Member;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TestStubListTest {

    @Test
    void get() {
        List<Member> testStubList = new TestStubList<>();

        assertThat(testStubList.get(0).getName(), is("홍길동"));
    }

    @Test
    void mockitoGet(){
        List<Member> list = mock(ArrayList.class);

        when(list.get(0)).thenReturn(Member.builder().id(1).name("홍길동").build());

        assertThat(list.get(0).getName(), is("홍길동"));
    }
}