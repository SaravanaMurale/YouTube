package com.valor.youtube.model;

import com.google.gson.annotations.SerializedName;

public class PostsResponse {

    @SerializedName("albumId")
    int albumId;
    @SerializedName("id")
    int id;
    @SerializedName("title")
    String title;
    @SerializedName("url")
    String url;
    @SerializedName("thumbnailUrl")
    String thumbnailUrl;

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
