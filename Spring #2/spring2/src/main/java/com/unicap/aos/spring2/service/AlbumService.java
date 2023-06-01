package com.unicap.aos.spring2.service;

import com.unicap.aos.spring2.domain.dto.AlbumCreateRequest;
import com.unicap.aos.spring2.domain.dto.AlbumDeleteResponse;
import com.unicap.aos.spring2.domain.dto.AlbumResponse;
import com.unicap.aos.spring2.domain.dto.AlbumUpdateRequest;
import com.unicap.aos.spring2.domain.entity.Album;
import com.unicap.aos.spring2.exception.AlbumNotFoundException;
import com.unicap.aos.spring2.exception.InvalidAlbumException;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class AlbumService {
    private static List<Album> repository = new ArrayList<>();
    private static int id = 1;

    public List<AlbumResponse> list() {
        List<AlbumResponse> response = new ArrayList<>();

        for (Album album : repository) {
            response.add(new AlbumResponse(album));
        }

        return response;
    }

    public AlbumResponse searchById(int id) {
        Optional<Album> searchedAlbum = findInRepository(id);

        if (searchedAlbum.isEmpty()) throw new AlbumNotFoundException(id);

        return new AlbumResponse(searchedAlbum.get());
    }

    public AlbumResponse create(AlbumCreateRequest request) {
        if (request.getReleaseYear() < 1950 || request.getReleaseYear() > LocalDate.now().getYear()) {
            throw new InvalidAlbumException("Release year must be between 1950 and current year.");
        }

        Album createdAlbum = new Album(AlbumService.id++, request);
        repository.add(createdAlbum);

        return new AlbumResponse(createdAlbum);
    }

    public AlbumResponse update(int id, AlbumUpdateRequest request) {
        if (request.getName().isBlank() && request.getArtist().isBlank() && (Integer)request.getReleaseYear() == null) {
            throw new InvalidAlbumException("At least one request field must be valid.");
        }

        Optional<Album> searchedAlbum = findInRepository(id);

        if (searchedAlbum.isEmpty()) throw new AlbumNotFoundException(id);

        Album updatedAlbum = searchedAlbum.get();
        int index = repository.indexOf(updatedAlbum);

        if (!request.getName().isBlank()) updatedAlbum.setName(request.getName());
        if (!request.getArtist().isBlank()) updatedAlbum.setArtist(request.getArtist());

        if (request.getReleaseYear() < 1950 || request.getReleaseYear() > LocalDate.now().getYear()) {
            throw new InvalidAlbumException("Release year must be between 1950 and current year.");
        } else {
            updatedAlbum.setReleaseYear(request.getReleaseYear());
        }

        repository.add(index, updatedAlbum);

        return new AlbumResponse(updatedAlbum);
    }

    public AlbumDeleteResponse delete(int id) {
        Optional<Album> searchedAlbum = findInRepository(id);

        if (searchedAlbum.isEmpty()) throw new AlbumNotFoundException(id);

        Album deletedAlbum = searchedAlbum.get();
        repository.remove(deletedAlbum);

        return new AlbumDeleteResponse(deletedAlbum.getId());
    }

    private Optional<Album> findInRepository(int id) {
        for (Album album : repository) {
            if (album.getId() == id) return Optional.of(album);
        }

        return Optional.empty();
    }
}
