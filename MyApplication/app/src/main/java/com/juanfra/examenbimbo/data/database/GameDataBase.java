package com.juanfra.examenbimbo.data.database;


import androidx.room.RoomDatabase;

public abstract class GameDataBase extends RoomDatabase {
    public abstract GameDataDao gameDataDao();
}
