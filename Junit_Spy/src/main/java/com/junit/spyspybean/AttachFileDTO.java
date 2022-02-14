package com.junit.spyspybean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttachFileDTO {
    long id;

    String fileName;

    boolean isDelete;
}
