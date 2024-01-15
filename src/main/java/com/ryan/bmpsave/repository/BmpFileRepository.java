package com.ryan.bmpsave.repository;

import com.ryan.bmpsave.domain.BmpFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BmpFileRepository extends JpaRepository <BmpFile, Long> {
}
