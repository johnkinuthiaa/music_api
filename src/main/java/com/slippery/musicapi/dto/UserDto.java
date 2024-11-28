package com.slippery.musicapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.slippery.musicapi.models.Playlist;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Long id;
    private String message;
    private Integer statusCode;
    private String error;
    private String username;
    private String email;
    private String password;
    private String role;
    private List<Playlist> playlists;
}
