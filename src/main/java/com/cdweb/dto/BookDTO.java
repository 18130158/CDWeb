package com.cdweb.dto;

import java.util.ArrayList;
import java.util.List;

public class BookDTO extends AbstractDTO<BookDTO> {
    private String active;
    private String title;
    private String shortDescription;
    private String description;
    private Long price;
    private Long quantity;
    private List<CategoryDTO> categoryList = new ArrayList<>();
    private List<AuthorDTO> authorList=new ArrayList<>();

    public BookDTO() {
    }

    public String getActive() {
        return active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(String active) {
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

    public List<CategoryDTO> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryDTO> categoryList) {
        this.categoryList = categoryList;
    }

    public List<AuthorDTO> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<AuthorDTO> authorList) {
        this.authorList = authorList;
    }
}
