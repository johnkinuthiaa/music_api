package com.slippery.musicapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MusicDto {
    private Long id;
    private String message;
    private Integer statusCode;
    private String error;
    private byte[] musicFile;
    private String fileType;
    private String fileName;
}
