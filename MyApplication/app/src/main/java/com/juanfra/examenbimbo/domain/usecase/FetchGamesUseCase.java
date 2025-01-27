package com.juanfra.examenbimbo.domain.usecase;

import io.reactivex.Observable;

import com.juanfra.examenbimbo.data.database.GameEntity;
import com.juanfra.examenbimbo.data.repository.DataBaseGameRepository;

import java.util.List;

import javax.inject.Inject;

public class FetchGamesUseCase {
    DataBaseGameRepository dataBaseGameRepository;

    @Inject
    public FetchGamesUseCase(DataBaseGameRepository dataBaseGameRepository){
        this.dataBaseGameRepository = dataBaseGameRepository;
    }

    public Observable<List<GameEntity>> fetchGames(){
        return dataBaseGameRepository.fetchGames();
    }
}
