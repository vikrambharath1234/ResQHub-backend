package com.resqhub.backend.controller;

import com.resqhub.backend.dto.SosRequestDto;
import com.resqhub.backend.entity.SosRequest;
import com.resqhub.backend.service.SosService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sos")
public class SosController {

    private final SosService sosService;

    public SosController(SosService sosService) {

        this.sosService = sosService;
    }


    // TRIGGER SOS
    @PostMapping
    public SosRequest triggerSos(
            @RequestBody SosRequestDto request) {

        return sosService.triggerSos(request);
    }


    // GET SOS HISTORY
    @GetMapping("/user/{userId}")
    public List<SosRequest> getSosHistory(
            @PathVariable Long userId) {

        return sosService.getSosHistory(userId);
    }
}