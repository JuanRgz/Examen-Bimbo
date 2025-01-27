package com.juanfra.examenbimbo.data.database;

import static com.juanfra.examenbimbo.data.database.GameEntity.TABLE_NAME;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = TABLE_NAME)
public class GameEntity {
    public static final String TABLE_NAME = "games";

    @PrimaryKey
    @ColumnInfo(name = "id")
    public Long id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "thumbnail")
    public String thumbnail;

    @ColumnInfo(name = "short_description")
    public String shortDescription;

    @ColumnInfo(name = "game_url")
    public String gameUrl;

    @ColumnInfo(name = "genre")
    public String genre;

    @ColumnInfo(name = "platform")
    public String platform;

    @ColumnInfo(name = "publisher")
    public String  publisher;

    @ColumnInfo(name = "developer")
    public String  developer;

    @ColumnInfo(name = "release_date")
    public String  releaseDate;

    @ColumnInfo(name = "freetogame_profile_url")
    public String  freetogameProfileUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getGameUrl() {
        return gameUrl;
    }

    public void setGameUrl(String gameUrl) {
        this.gameUrl = gameUrl;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getFreetogameProfileUrl() {
        return freetogameProfileUrl;
    }

    public void setFreetogameProfileUrl(String freetogameProfileUrl) {
        this.freetogameProfileUrl = freetogameProfileUrl;
    }
}
