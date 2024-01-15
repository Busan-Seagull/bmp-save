package com.ryan.bmpsave.service;

import com.ryan.bmpsave.domain.BmpFile;
import com.ryan.bmpsave.repository.BmpFileRepository;
import com.ryan.bmpsave.service.dto.BmpFileDto;
import com.ryan.bmpsave.service.mapper.BmpFileMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BmpFileService {

    private final BmpFileRepository bmpSaveRepository;

    private final BmpFileMapper bmpFileMapper;

    public byte[] getImageData(Long id) {
        BmpFile bmpFile = bmpSaveRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Image not found"));
        return bmpFile.getImageData();
    }

    public BmpFile uploadBmpFile(BmpFileDto bmpFileDto) throws IOException{

        // MultipartFile 에서 바이트 배열로 이미지 데이터 추출
        byte[] imageData = bmpFileDto.getFile().getBytes();

        // FileEntity 생성 및 값 설정
        BmpFile bmpFile = bmpFileMapper.toEntity(bmpFileDto);
        bmpFile.setImageData(imageData);
        bmpFile.setCreatedAt(LocalDateTime.now());

        // JPA를 사용하여 엔티티 저장
        bmpFile = bmpSaveRepository.save(bmpFile);

        // 로컬 스토리지에 저장한다면 구현
//        String fileUri = storeImage(fileName, fileType, width, height, imageData);

        return bmpFile;
    }

    private String storeImage(String fileName, String fileType, int width, int height, byte[] imageData) {
        //여기에 실제로 이미지를 저장, 저장된 파일의 URI를 생성하는 로직
        String fileUri = "/uploads/" + System.currentTimeMillis() + "_" + fileName;
        return fileUri;
    }

}
