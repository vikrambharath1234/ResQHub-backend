package com.resqhub.backend.service;

import com.resqhub.backend.dto.SosRequestDto;
import com.resqhub.backend.entity.SosRequest;
import com.resqhub.backend.repository.SosRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SosService {

    private final SosRepository sosRepository;

    public SosService(SosRepository sosRepository) {

        this.sosRepository = sosRepository;
    }

    // TRIGGER SOS
    public SosRequest triggerSos(SosRequestDto request) {

        SosRequest sosRequest = new SosRequest();

        sosRequest.setUserId(request.getUserId());
        sosRequest.setMessage(request.getMessage());
        sosRequest.setLocation(request.getLocation());
        sosRequest.setCreatedAt(LocalDateTime.now());

        return sosRepository.save(sosRequest);
    }

    // SOS HISTORY
    public List<SosRequest> getSosHistory(Long userId) {

        return sosRepository.findByUserId(userId);
    }
}