package com.boots.repository;

import com.boots.entity.CodeFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeFileRepository extends JpaRepository<CodeFile, Long> {
    CodeFile findByUuid(String uuid);
    void deleteByUuid(String uuid);
}

