package com.cdweb.dto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class BookDTO extends AbstractDTO<BookDTO> {
    private boolean active;
    private String title;
    private String shortDescription;
    private String description;
    private double discount;
    private Long price;
    private Long quantity;
    private Long page;
    private boolean newBook;
    private boolean hotBook;
    private String publisher;
    private AuthorDTO author;
    private CategoryDTO category;
    private List<MediaDTO> mediaList = new ArrayList<>();



    public BookDTO() {
    }

    public boolean isNewBook() {
        return newBook;
    }

    public void setNewBook(boolean newBook) {
        this.newBook = newBook;
    }

    public boolean isHotBook() {
        return hotBook;
    }

    public void setHotBook(boolean hotBook) {
        this.hotBook = hotBook;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public List<MediaDTO> getMediaList() {
        return mediaList;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setMediaList(List<MediaDTO> mediaList) {
        this.mediaList = mediaList;
    }
    public String getPriceFormat(){
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(this.price)+" VNĐ";
    }
    public String getPriceDiscount(){
        double price=this.price*(1-this.discount/100);
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(price)+" VNĐ";
    }
    public String getDiscountFormat(){
        DecimalFormat formatter = new DecimalFormat("##.##");
        return formatter.format(discount)+"%";
    }


}
