package com.cdweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "commnent")
public class CommentEntity extends BaseEntity {
    //column
    @Column
    private String review;
    //map
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    //getter,setter
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
