package com.junit.spyspybean;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AttachFile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;

    String fileName;

    boolean isDelete;

    public static AttachFile of(AttachFileDTO attachFileDTO){
        return AttachFile.builder()
                .id(attachFileDTO.getId())
                .fileName(attachFileDTO.getFileName())
                .isDelete(attachFileDTO.isDelete())
                .build();
    }
}
