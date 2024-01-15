package com.ryan.bmpsave.controller;

import com.ryan.bmpsave.domain.BmpFile;
import com.ryan.bmpsave.service.BmpFileService;
import com.ryan.bmpsave.service.dto.BmpFileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/file")
public class BmpFileController {

    private final BmpFileService bmpFileService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getImage(@PathVariable Long id) {
        //이미지 데이터 가져오기
        byte[] imageData = bmpFileService.getImageData(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("image/bmp"));
        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> insertBmpFile(
            @RequestPart("file") MultipartFile file,
            @RequestParam("fileName") String fileName,
            @RequestParam("fileType") String fileType,
            @RequestParam("width") int width,
            @RequestParam("height") int height
    ) throws IOException {
        BmpFileDto bmpFileDto = BmpFileDto.builder()
                .file(file)
                .fileName(fileName)
                .fileType(fileType)
                .width(width)
                .height(height)
                .build();

        BmpFile savedBmpFile = bmpFileService.uploadBmpFile(bmpFileDto);

        return ResponseEntity.ok(savedBmpFile);
    }


}
