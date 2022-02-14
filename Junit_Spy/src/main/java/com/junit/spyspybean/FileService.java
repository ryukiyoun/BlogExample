package com.junit.spyspybean;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
public class FileService {
    private final String FILE_PATH = "./file";

    private final AttachFileRepository attachFileRepository;

    public boolean updateFile(AttachFileDTO fileDTO) {
        if(fileDTO.isDelete){
            attachFileRepository.deleteById(fileDTO.id);
            return deleteFile(fileDTO.fileName);
        }
        else {
            attachFileRepository.save(AttachFile.of(fileDTO));
            return true;
        }
    }

    public boolean deleteFile(String fileName){
        File file = new File(FILE_PATH + File.separator + fileName);

        return file.delete();
    }
}
