package com.cdweb.dto;

public class MediaDTO extends AbstractDTO<MediaDTO>{
    private String path;
    private BookDTO book;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }
}
