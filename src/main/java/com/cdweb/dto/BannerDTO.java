package com.cdweb.dto;

public class BannerDTO extends AbstractDTO<BannerDTO>{
    private String name;
    private String url;

    public BannerDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
