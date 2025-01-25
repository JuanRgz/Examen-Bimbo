package com.development.myapplication.data.database;

import android.database.Observable;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GameDataDao {
    @Insert
    void insert(Game game);

    @Query("DELETE FROM " + Game.TABLE_NAME)
    void DeleteAll();

    @Query("SELECT * FROM " + Game.TABLE_NAME)
    Observable<List<Game>> fetchGames();
}
