package com.juanfra.examenbimbo.domain.model;

import com.juanfra.examenbimbo.data.database.GameEntity;

public class GameDomain {
    public Long id;
    public String title;
    public String thumbnail;
    public String shortDescription;
    public String gameUrl;
    public String genre;
    public String platform;
    public String publisher;
    public String developer;
    public String releaseDate;
    public String freetogameProfileUrl;

    public GameDomain(GameModel res){
        this.id = res.getId();
        this.title = res.getTitle();
        this.thumbnail = res.getThumbnail();
        this.shortDescription = res.getShortDescription() ;
        this.gameUrl = res.getGameUrl();
        this.genre = res.getGenre();
        this.platform = res.getPlatform();
        this.publisher = res.getPublisher();
        this.developer = res.getDeveloper();
        this.releaseDate = res.getReleaseDate();
        this.freetogameProfileUrl = res.getFreetogameProfileUrl();
    }

    public GameDomain(GameEntity res){
        this.id = res.id;
        this.title = res.title;
        this.thumbnail = res.thumbnail;
        this.shortDescription = res.shortDescription;
        this.gameUrl = res.gameUrl;
        this.genre = res.genre;
        this.platform = res.platform;
        this.publisher = res.publisher;
        this.developer = res.developer;
        this.releaseDate = res.releaseDate;
        this.freetogameProfileUrl = res.freetogameProfileUrl;
    }
}