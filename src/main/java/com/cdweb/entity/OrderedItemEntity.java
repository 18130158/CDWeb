package com.cdweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "ordered_item")
public class OrderedItemEntity {
    //column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long quantity;
    @Column
    private Long totalPrice;
    //map
    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "ordered_id")
    private OrderedEntity ordered;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //getter,setter
    public OrderedEntity getOrdered() {
        return ordered;
    }

    public void setOrdered(OrderedEntity ordered) {
        this.ordered = ordered;
    }


    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

}
