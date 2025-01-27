package com.juanfra.examenbimbo.data.repository;

import com.juanfra.examenbimbo.data.network.GameService;
import com.juanfra.examenbimbo.domain.model.GamesResponse;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GameRepository {
    public GameService gameService;

    @Inject
    public GameRepository(GameService gameService) { this.gameService = gameService; }

    public Observable<GamesResponse> getGames(){
        return gameService.getGames();
    }
}
