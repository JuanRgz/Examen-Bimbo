package com.juanfra.examenbimbo.data.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = { GameEntity.class }, version = 1, exportSchema = false)
public abstract class GameDataBase extends RoomDatabase {
    public abstract GameDataDao gameDataDao();
}
