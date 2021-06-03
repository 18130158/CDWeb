package com.cdweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class BookEntity extends BaseEntity {
    //column
    @Column
    private String title;
    @Column
    private String active;
    @Column
    private String shortDescription;
    @Column
    private String description;
    @Column
    private Long price;
    @Column
    private Long quantity;
    @ManyToMany
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<AuthorEntity> authorList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "category_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryEntity> categoryList = new ArrayList<>();

    public List<CategoryEntity> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryEntity> categoryList) {
        this.categoryList = categoryList;
    }

    public List<AuthorEntity> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<AuthorEntity> authorList) {
        this.authorList = authorList;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
