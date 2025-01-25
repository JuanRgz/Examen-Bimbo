package com.development.myapplication.di;

import android.content.Context;

import androidx.room.Room;

import com.development.myapplication.data.database.GameDataBase;
import com.development.myapplication.data.database.GameDataDao;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@InstallIn(SingletonComponent.class)
@Module
public class DatabaseModule {
    GameDataBase provideAppDatabase(@ApplicationContext Context appContext){
        return Room.databaseBuilder(
                appContext,
                GameDataBase.class,
                "Games"
        ).allowMainThreadQueries().build();
    }

    @Provides
    GameDataDao provideGameDataDao(GameDataBase gameDataBase){
        return gameDataBase.gameDataDao();
    }
}
