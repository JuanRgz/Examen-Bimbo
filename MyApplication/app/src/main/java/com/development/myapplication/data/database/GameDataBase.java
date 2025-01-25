package com.development.myapplication.data.database;


import androidx.room.RoomDatabase;

public abstract class GameDataBase extends RoomDatabase {
    public abstract GameDataDao gameDataDao();
}
