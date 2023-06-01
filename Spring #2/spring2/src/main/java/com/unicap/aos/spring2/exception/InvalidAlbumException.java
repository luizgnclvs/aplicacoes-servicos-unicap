package com.unicap.aos.spring2.exception;

public class InvalidAlbumException extends RuntimeException {
    public InvalidAlbumException(String message) {
        super(message);
    }
}
