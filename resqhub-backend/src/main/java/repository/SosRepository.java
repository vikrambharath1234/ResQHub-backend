package com.resqhub.backend.repository;

import com.resqhub.backend.entity.SosRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SosRepository
        extends JpaRepository<SosRequest, Long> {

    List<SosRequest> findByUserId(Long userId);
}