package com.slippery.musicapi.service;

import com.slippery.musicapi.dto.MusicDto;
import com.slippery.musicapi.models.IndividualTracks;
import org.springframework.web.multipart.MultipartFile;

public interface IndividualTracksService {

    MusicDto createNewTrack(MultipartFile track);
    IndividualTracks updateTrack(MultipartFile track,Long id);
    IndividualTracks findTrackById(Long id);
    IndividualTracks findTrackByName(String name);
    IndividualTracks deleteById(Long id);
    IndividualTracks deleteAllTracks();
}
