package com.cdweb.dto;

public class OrderedItemDTO   {
    private Long id;
    private OrderedDTO ordered;
    private BookDTO book;
    private Long quantity;
    private double totalPrice;

    public OrderedItemDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderedDTO getOrdered() {
        return ordered;
    }

    public void setOrdered(OrderedDTO ordered) {
        this.ordered = ordered;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
