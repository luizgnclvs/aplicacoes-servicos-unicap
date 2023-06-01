package com.unicap.aos.spring2.domain.dto;

import lombok.Data;

@Data
public class AlbumDeleteResponse {
    private int id;
    private boolean ok;

    public AlbumDeleteResponse(int id) {
        this.id = id;
        this.ok = true;
    }
}
