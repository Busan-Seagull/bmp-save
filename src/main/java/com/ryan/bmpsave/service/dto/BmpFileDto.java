package com.ryan.bmpsave.service.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
public class BmpFileDto {
    private MultipartFile file;
    private String fileName;
    private String fileType;
    private int width;
    private int height;

}
