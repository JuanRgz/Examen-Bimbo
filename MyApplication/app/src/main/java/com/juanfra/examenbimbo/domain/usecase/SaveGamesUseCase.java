package com.juanfra.examenbimbo.domain.usecase;

import com.juanfra.examenbimbo.data.database.GameEntity;
import com.juanfra.examenbimbo.data.repository.DataBaseGameRepository;
import javax.inject.Inject;

public class SaveGamesUseCase {
    DataBaseGameRepository dataBaseGameRepository;
    @Inject
    public SaveGamesUseCase(DataBaseGameRepository dataBaseGameRepository){
        this.dataBaseGameRepository = dataBaseGameRepository;
    }

    public void saveGame(GameEntity gameEntity){
        dataBaseGameRepository.saveGame(gameEntity);
    }
}
