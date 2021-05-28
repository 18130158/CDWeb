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
    private String shortDescription;
    @Column
    private String description;
    @Column
    private Long price;
    @Column
    private Long quantity;
//map

    @ManyToOne
    @JoinColumn(name = "active_id")
    private ActiveEntity active;

    @OneToMany(mappedBy = "book")
    private List<CommentEntity> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<OrderedItemEntity> orderedItemList = new ArrayList<>();

    @ManyToMany(mappedBy = "bookList")
    private List<UserEntity> userList = new ArrayList<>();

    @ManyToMany(mappedBy = "bookList")
    private List<AuthorEntity> authorList = new ArrayList<>();

    @ManyToMany(mappedBy = "bookList")
    private List<ShopEntity> shopList = new ArrayList<>();

    @ManyToMany(mappedBy = "bookList")
    private List<CatergoryEntity> catergoryList = new ArrayList<>();

    //getter, setter
    public List<CatergoryEntity> getCatergoryList() {
        return catergoryList;
    }

    public void setCatergoryList(List<CatergoryEntity> catergoryList) {
        this.catergoryList = catergoryList;
    }

    public List<CommentEntity> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentEntity> commentList) {
        this.commentList = commentList;
    }

    public List<UserEntity> getUserList() {
        return userList;
    }

    public void setUserList(List<UserEntity> userList) {
        this.userList = userList;
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

    public ActiveEntity getActive() {
        return active;
    }

    public void setActive(ActiveEntity active) {
        this.active = active;
    }

    public List<AuthorEntity> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<AuthorEntity> authorList) {
        this.authorList = authorList;
    }

    public List<ShopEntity> getShopList() {
        return shopList;
    }

    public void setShopList(List<ShopEntity> shopList) {
        this.shopList = shopList;
    }

    public List<OrderedItemEntity> getOrderedItemList() {
        return orderedItemList;
    }

    public void setOrderedItemList(List<OrderedItemEntity> orderedItemList) {
        this.orderedItemList = orderedItemList;
    }
}
