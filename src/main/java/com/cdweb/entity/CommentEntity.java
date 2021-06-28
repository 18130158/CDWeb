package com.cdweb.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "comment")
public class CommentEntity {
    //column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String review;
    @Column
    private Timestamp dateCreated;
    //map
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }


    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    //getter,setter
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
