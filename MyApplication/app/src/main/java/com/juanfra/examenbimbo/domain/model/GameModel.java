package com.juanfra.examenbimbo.domain.model;

import com.google.gson.annotations.SerializedName;

public class GameModel {
    private Long id;
    private String title;
    private String thumbnail;
    @SerializedName("short_description")
    private String shortDescription;
    @SerializedName("game_url")
    private String gameUrl;
    private String genre;
    private String platform;
    private String publisher;
    private String developer;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("freetogame_profile_url")
    private String freetogameProfileUrl;

    public GameModel(Long id, String title, String thumbnail, String shortDescription, String gameUrl, String genre, String platform, String publisher, String developer, String releaseDate, String freetogameProfileUrl) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.shortDescription = shortDescription;
        this.gameUrl = gameUrl;
        this.genre = genre;
        this.platform = platform;
        this.publisher = publisher;
        this.developer = developer;
        this.releaseDate = releaseDate;
        this.freetogameProfileUrl = freetogameProfileUrl;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getThumbnail() { return thumbnail; }

    public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }

    public String getShortDescription() { return shortDescription; }

    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    public String getGameUrl() { return gameUrl; }

    public void setGameUrl(String gameUrl) { this.gameUrl = gameUrl; }

    public String getGenre() { return genre; }

    public void setGenre(String genre) { this.genre = genre; }

    public String getPlatform() { return platform; }

    public void setPlatform(String platform) { this.platform = platform; }

    public String getPublisher() { return publisher; }

    public void setPublisher(String publisher) { this.publisher = publisher; }

    public String getDeveloper() { return developer; }

    public void setDeveloper(String developer) { this.developer = developer; }

    public String getReleaseDate() { return releaseDate; }

    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    public String getFreetogameProfileUrl() { return freetogameProfileUrl; }

    public void setFreetogameProfileUrl(String freetogameProfileUrl) { this.freetogameProfileUrl = freetogameProfileUrl; }
}