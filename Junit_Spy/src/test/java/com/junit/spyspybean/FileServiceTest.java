package com.junit.spyspybean;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class FileServiceTest {
    @Mock
    AttachFileRepository attachFileRepository;

    @Spy
    @InjectMocks
    FileService fileService;

    @Test
    void updateFile() {
        AttachFileDTO attachFileDTO = AttachFileDTO.builder()
                .id(1)
                .fileName("test.txt")
                .isDelete(true)
                .build();

        doNothing().when(attachFileRepository).deleteById(anyLong());

        doReturn(true).when(fileService).deleteFile(anyString());

        assertThat(fileService.updateFile(attachFileDTO), is(true));
    }
}