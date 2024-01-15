package com.ryan.bmpsave.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Blob;
import java.time.LocalDateTime;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "bmp_files")
public class BmpFile {
    //GeneratedValue : 기본키의 값을 자동으로 생성
    //Lob : Large Object 데이터를 저장
    //columnDefinition : 컬럼의 기본값을 설정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long key;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Lob
    @Column(name = "image_data", nullable = false)
    private byte[] imageData;

    @Column(name = "file_type", nullable = false)
    private String fileType;

    @Column(name = "width")
    private int width;

    @Column(name = "height")
    private int height;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

}
