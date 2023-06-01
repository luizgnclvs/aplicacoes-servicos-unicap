package com.unicap.aos.spring2.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AlbumCreateRequest {
    @NotBlank(message = "Name must be defined")
    private String name;

    @NotBlank(message = "Artist must be defined")
    private String artist;

    @NotNull(message = "Release year must be defined")
    private int releaseYear;
}
