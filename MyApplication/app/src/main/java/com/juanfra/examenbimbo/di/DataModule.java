package com.juanfra.examenbimbo.di;

import com.juanfra.examenbimbo.data.database.GameDataDao;
import com.juanfra.examenbimbo.data.network.GameService;
import com.juanfra.examenbimbo.data.repository.DataBaseGameRepository;
import com.juanfra.examenbimbo.data.repository.GameRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@InstallIn(SingletonComponent.class)
@Module
public class DataModule {
    @Provides
    GameRepository providesGameRepository(GameService gameService){
        return new GameRepository(gameService);
    }

    @Provides
    DataBaseGameRepository providesDataBaseGameRepository(GameDataDao gameDataDao){
        return new DataBaseGameRepository(gameDataDao);
    }
}
