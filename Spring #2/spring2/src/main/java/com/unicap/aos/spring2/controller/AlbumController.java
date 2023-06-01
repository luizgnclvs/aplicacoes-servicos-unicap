package com.unicap.aos.spring2.controller;

import com.unicap.aos.spring2.domain.dto.AlbumCreateRequest;
import com.unicap.aos.spring2.domain.dto.AlbumDeleteResponse;
import com.unicap.aos.spring2.domain.dto.AlbumResponse;
import com.unicap.aos.spring2.domain.dto.AlbumUpdateRequest;
import com.unicap.aos.spring2.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping
    public ResponseEntity<List<AlbumResponse>> getAlbums() {
        return ResponseEntity.ok(albumService.list());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AlbumResponse> getAlbumById(@PathVariable int id) {
        return ResponseEntity.ok(albumService.searchById(id));
    }

    @PostMapping
    public ResponseEntity<AlbumResponse> postAlbum(@RequestBody @Valid AlbumCreateRequest request) {
        return ResponseEntity.ok(albumService.create(request));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AlbumResponse> putAlbum(@PathVariable int id, @RequestBody AlbumUpdateRequest request) {
        return ResponseEntity.ok(albumService.update(id, request));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AlbumDeleteResponse> deleteAlbum(@PathVariable int id) {
        return ResponseEntity.ok(albumService.delete(id));
    }
}
