package com.cdweb.dto;

public class OrderedItemDTO extends  AbstractDTO<OrderedItemDTO>{
    private OrderedDTO orderedDTO;
    private BookDTO bookDTO;
    private Long quantity;
    private Long totalPrice;

    public OrderedItemDTO() {
    }

    public OrderedDTO getOrderedDTO() {
        return orderedDTO;
    }

    public void setOrderedDTO(OrderedDTO orderedDTO) {
        this.orderedDTO = orderedDTO;
    }

    public BookDTO getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(BookDTO bookDTO) {
        this.bookDTO = bookDTO;
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
}
