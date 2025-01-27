package com.juanfra.examenbimbo.data.repository;

import io.reactivex.Observable;

import com.juanfra.examenbimbo.data.database.GameEntity;
import com.juanfra.examenbimbo.data.database.GameDataDao;

import java.util.List;

import javax.inject.Inject;

public class DataBaseGameRepository {
    GameDataDao gameDataDao;

    @Inject
    public DataBaseGameRepository(GameDataDao gameDataDao){ this.gameDataDao = gameDataDao; }

    public Observable<List<GameEntity>> fetchGames() {
        return gameDataDao.fetchGames(); }

    public void saveGame(GameEntity gameEntity){
        gameDataDao.insert(gameEntity); }

    public void deleteGame() { gameDataDao.deleteAll(); }

    //public Observable<Game> getGame(Long gameId) { return gameDataDao.getGame(gameId) }

}
