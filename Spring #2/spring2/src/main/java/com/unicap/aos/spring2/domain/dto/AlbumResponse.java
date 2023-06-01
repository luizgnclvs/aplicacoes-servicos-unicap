package com.unicap.aos.spring2.domain.dto;

import com.unicap.aos.spring2.domain.entity.Album;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlbumResponse {
    private int id;
    private String name;
    private String artist;
    private int releaseYear;

    public AlbumResponse(Album album) {
        this.id = album.getId();
        this.name = album.getName();
        this.artist = album.getArtist();
        this.releaseYear = album.getReleaseYear();
    }
}
