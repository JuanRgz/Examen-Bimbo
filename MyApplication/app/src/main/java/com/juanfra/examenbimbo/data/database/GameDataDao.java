package com.juanfra.examenbimbo.data.database;

import io.reactivex.Observable;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface GameDataDao {
    @Insert
    void insert(GameEntity gameEntity);

    /*@Query("SELECT * FROM " + Game.TABLE_NAME + " WHERE game_id = :gameId")
    Observable<Game> getGame(Long gaameId);*/

    @Query("DELETE FROM " + GameEntity.TABLE_NAME)
    void deleteAll();

    @Query("SELECT * FROM " + GameEntity.TABLE_NAME)
    Observable<List<GameEntity>> fetchGames();
}
