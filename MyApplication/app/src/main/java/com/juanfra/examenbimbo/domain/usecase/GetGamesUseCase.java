package com.juanfra.examenbimbo.domain.usecase;

import com.juanfra.examenbimbo.data.repository.GameRepository;
import com.juanfra.examenbimbo.domain.model.GamesResponse;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetGamesUseCase {
    GameRepository repository;

    @Inject
    public GetGamesUseCase(GameRepository repository) { this.repository = repository; }

    public Observable<GamesResponse> getGames(){
        return repository.getGames();
    }
}
