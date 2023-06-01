package com.unicap.aos.spring2.domain.dto;

import lombok.Data;

@Data
public class AlbumUpdateRequest {
    private String name;
    private String artist;
    private int releaseYear;
}
