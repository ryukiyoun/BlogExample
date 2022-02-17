package com.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServiceTest {

    @Test
    void requestHttpThenReturn() {
        HttpRequestUtil httpRequestUtil = mock(HttpRequestUtil.class);

        Service service = new Service(httpRequestUtil);

        when(httpRequestUtil.getRequest(anyString())).thenReturn("thenReturn result");

        assertThat(service.requestHttp("testURL", "testParam"), is("thenReturn result"));
    }

    @Test
    void requestHttpDoReturn() {
        HttpRequestUtil httpRequestUtil = mock(HttpRequestUtil.class);

        Service service = new Service(httpRequestUtil);

        doReturn("doReturn result").when(httpRequestUtil).getRequest(anyString());

        assertThat(service.requestHttp("testURL", "testParam"), is("doReturn result"));
    }

    @Test
    void requestHttpSpyThenReturn() {
        HttpRequestUtil httpRequestUtil = spy(HttpRequestUtil.class);

        Service service = new Service(httpRequestUtil);

        when(httpRequestUtil.getRequest(anyString())).thenReturn("thenReturn result");

        assertThat(service.requestHttp("testURL", "testParam"), is("thenReturn result"));
    }

    @Test
    void requestHttpSpyDoReturn() {
        HttpRequestUtil httpRequestUtil = spy(HttpRequestUtil.class);

        Service service = new Service(httpRequestUtil);

        doReturn("doReturn result").when(httpRequestUtil).getRequest(anyString());

        assertThat(service.requestHttp("testURL", "testParam"), is("doReturn result"));
    }
}