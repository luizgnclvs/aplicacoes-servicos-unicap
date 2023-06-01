package com.unicap.aos.spring2.domain.entity;

import com.unicap.aos.spring2.domain.dto.AlbumCreateRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    private int id;
    private String name;
    private String artist;
    private int releaseYear;

    public Album(int id, AlbumCreateRequest request) {
        this.id = id;
        this.name = request.getName();
        this.artist = request.getArtist();
        this.releaseYear = request.getReleaseYear();
    }
}
