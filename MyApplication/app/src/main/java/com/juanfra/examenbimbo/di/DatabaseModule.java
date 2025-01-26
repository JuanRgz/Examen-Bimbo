package com.juanfra.examenbimbo.di;

import android.content.Context;
import androidx.room.Room;

import com.juanfra.examenbimbo.data.database.GameDataBase;
import com.juanfra.examenbimbo.data.database.GameDataDao;

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
