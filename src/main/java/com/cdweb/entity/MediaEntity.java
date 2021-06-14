package com.cdweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "media")
public class MediaEntity extends BaseEntity {
    @Column
    private String path;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }
}
