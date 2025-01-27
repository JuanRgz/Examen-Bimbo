package com.juanfra.examenbimbo.di;

import com.juanfra.examenbimbo.data.repository.DataBaseGameRepository;
import com.juanfra.examenbimbo.data.repository.GameRepository;
import com.juanfra.examenbimbo.domain.usecase.DeleteGamesUseCase;
import com.juanfra.examenbimbo.domain.usecase.FetchGamesUseCase;
import com.juanfra.examenbimbo.domain.usecase.GetGamesUseCase;
import com.juanfra.examenbimbo.domain.usecase.SaveGamesUseCase;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@InstallIn(SingletonComponent.class)
@Module
public class DomainModule {
    @Provides
    public GetGamesUseCase providesBeers(GameRepository repository )  {
        return new GetGamesUseCase(repository);
    }

    @Provides
    FetchGamesUseCase providesFetchBeers(DataBaseGameRepository dataBaseBeerRepository){
        return new FetchGamesUseCase(dataBaseBeerRepository);
    }

    @Provides
    SaveGamesUseCase providesSaveBeers(DataBaseGameRepository dataBaseBeerRepository){
        return new SaveGamesUseCase(dataBaseBeerRepository);
    }

    @Provides
    DeleteGamesUseCase providesDeleteBeers(DataBaseGameRepository dataBaseBeerRepository){
        return new DeleteGamesUseCase(dataBaseBeerRepository);
    }
}
