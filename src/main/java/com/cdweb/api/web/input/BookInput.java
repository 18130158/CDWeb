package com.cdweb.api.web.input;

public class BookInput {
    private long category=0;
    private Integer page=1;
    private Integer limit=12;
    private String sortName="id";
    private String sortBy="asc";
    private boolean hot=false;
    private boolean newBook=false;
    private boolean sale=false;




    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }


    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public boolean isNewBook() {
        return newBook;
    }

    public void setNewBook(boolean newBook) {
        this.newBook = newBook;
    }

    public boolean isSale() {
        return sale;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }
}
