package com.juanfra.examenbimbo.domain.usecase;

import com.juanfra.examenbimbo.data.repository.DataBaseGameRepository;

import javax.inject.Inject;

public class DeleteGamesUseCase {
    DataBaseGameRepository dataBaseGameRepository;

    @Inject
    public DeleteGamesUseCase(DataBaseGameRepository dataBaseGameRepository){
        this.dataBaseGameRepository = dataBaseGameRepository;
    }

    public void deleteGames(){ dataBaseGameRepository.deleteGame(); }
}
