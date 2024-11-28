package com.slippery.musicapi.repository;

import com.slippery.musicapi.models.IndividualTracks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualTracksRepository extends JpaRepository<IndividualTracks,Long> {
    IndividualTracks findByFileName(String name);
}
