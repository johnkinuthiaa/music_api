package com.slippery.musicapi.service.impl;

import com.slippery.musicapi.dto.MusicDto;
import com.slippery.musicapi.models.IndividualTracks;
import com.slippery.musicapi.repository.IndividualTracksRepository;
import com.slippery.musicapi.service.IndividualTracksService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class IndividualTracksImpl implements IndividualTracksService {
    private final IndividualTracksRepository repository;
    public IndividualTracksImpl(IndividualTracksRepository repository){
        this.repository=repository;
    }
    @Override
    public MusicDto createNewTrack(MultipartFile track) {
        MusicDto response =new MusicDto();
        IndividualTracks newTrack =new IndividualTracks();
        try{
            newTrack.setFileName(track.getOriginalFilename());
            newTrack.setMusicFile(track.getBytes());
            newTrack.setFileType(track.getContentType());
            repository.save(newTrack);
            response.setMessage("music file saved Successfully");
            response.setStatusCode(200);
        } catch (Exception e) {
            response.setError(e.getMessage());
        }
        return response;
    }

    @Override
    public IndividualTracks updateTrack(MultipartFile track, Long id) {
        return null;
    }

    @Override
    public IndividualTracks findTrackById(Long id) {
        return null;
    }

    @Override
    public IndividualTracks findTrackByName(String name) {
        return null;
    }

    @Override
    public IndividualTracks deleteById(Long id) {
        return null;
    }

    @Override
    public IndividualTracks deleteAllTracks() {
        return null;
    }
}
