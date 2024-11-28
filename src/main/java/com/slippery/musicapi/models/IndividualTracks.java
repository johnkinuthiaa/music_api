package com.slippery.musicapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IndividualTracks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private byte[] musicFile;
    private String fileType;
    private String fileName;
    @ManyToOne
    @JoinColumn(name="playList_id", nullable=false)
    private Playlist playlist;

}
