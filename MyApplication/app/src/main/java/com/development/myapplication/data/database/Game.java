package com.development.myapplication.data.database;

import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

public class Game{
    public static final String TABLE_NAME = "games";

    @PrimaryKey
    public Long id;

    public String title;

    public String thumbnail;

    @SerializedName("short_description")
    public String shortDescription;

    @SerializedName("game_url")
    public String gameUrl;

    public String genre;

    public String platform;

    public String  publisher;

    public String  developer;

    @SerializedName("release_date")
    public String  releaseDate;

    @SerializedName("freetogame_profile_url")
    public String  freetogameProfileUrl;
}
