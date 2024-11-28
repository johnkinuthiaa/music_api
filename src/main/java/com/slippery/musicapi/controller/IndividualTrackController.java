package com.slippery.musicapi.controller;

import com.slippery.musicapi.dto.MusicDto;
import com.slippery.musicapi.service.IndividualTracksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/music-app")
public class IndividualTrackController {
    private final IndividualTracksService service;
    public IndividualTrackController(IndividualTracksService service){
        this.service=service;
    }
    @PostMapping("/upload")
    public ResponseEntity<MusicDto> createNewTrack(@RequestParam MultipartFile track){
        return ResponseEntity.ok(service.createNewTrack(track));

    }
}
