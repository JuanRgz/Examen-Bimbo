package com.juanfra.examenbimbo.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.juanfra.examenbimbo.data.database.GameEntity;
import com.juanfra.examenbimbo.domain.model.GameModel;
import com.juanfra.examenbimbo.domain.usecase.DeleteGamesUseCase;
import com.juanfra.examenbimbo.domain.usecase.GetGamesUseCase;
import com.juanfra.examenbimbo.domain.usecase.SaveGamesUseCase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


@HiltViewModel
public class ListViewModel extends ViewModel {
    CompositeDisposable disposables = new CompositeDisposable();
    private GetGamesUseCase getGamesUseCase;
    private DeleteGamesUseCase deleteGamesUseCase;
    private SaveGamesUseCase saveGamesUseCase;

    public MutableLiveData<String> errorLiveData = new MutableLiveData<>();
    public MutableLiveData<List<GameModel>> gameLiveData = new MutableLiveData<>();
    public MutableLiveData<List<GameModel>> resultsLiveData = new MutableLiveData<>();

    @Inject
    public ListViewModel(GetGamesUseCase getGamesUseCase,
                         DeleteGamesUseCase deleteGamesUseCase,
                         SaveGamesUseCase saveGamesUseCase){
        this.getGamesUseCase = getGamesUseCase;
        this.deleteGamesUseCase = deleteGamesUseCase;
        this.saveGamesUseCase = saveGamesUseCase;
    }

    public void getGames(){
        disposables.add(getGamesUseCase.getGames()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> {
                            deleteGames();
                            ArrayList<GameModel> gameDomainArrayList = new ArrayList<>();
                            for (GameModel res:result) {
                                gameDomainArrayList.add(new GameModel(
                                        res.getId(),
                                        res.getTitle(),
                                        res.getThumbnail(),
                                        res.getShortDescription(),
                                        res.getGameUrl(),
                                        res.getGenre(),
                                        res.getPlatform(),
                                        res.getPublisher(),
                                        res.getDeveloper(),
                                        res.getReleaseDate(),
                                        res.getFreetogameProfileUrl()
                                ));
                                saveGame(res);
                            }
                            resultsLiveData.postValue(gameDomainArrayList);
                        },
                        error -> errorLiveData.postValue("Error occurred: ")
                ));
    }

    public void fetchGames(){
        disposables.add(getGamesUseCase.getGames()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> {
                            deleteGames();
                            ArrayList<GameModel> gameDomainArrayList = new ArrayList<>();
                            for (GameModel res:result) {
                                gameDomainArrayList.add(new GameModel(
                                        res.getId(),
                                        res.getTitle(),
                                        res.getThumbnail(),
                                        res.getShortDescription(),
                                        res.getGameUrl(),
                                        res.getGenre(),
                                        res.getPlatform(),
                                        res.getPublisher(),
                                        res.getDeveloper(),
                                        res.getReleaseDate(),
                                        res.getFreetogameProfileUrl()
                                ));
                                saveGame(res);
                            }
                            resultsLiveData.postValue(gameDomainArrayList);
                        },
                        error -> errorLiveData.postValue("Error occurred: ")
                ));
    }

    public void deleteGames(){
        deleteGamesUseCase.deleteGames();
    }

    public void saveGame(GameModel res){
        GameEntity gameEntity = new GameEntity();
        gameEntity.id = res.getId();
        gameEntity.title = res.getTitle();
        gameEntity.thumbnail = res.getThumbnail();
        gameEntity.shortDescription = res.getShortDescription();
        gameEntity.gameUrl = res.getGameUrl();
        gameEntity.genre = res.getGenre();
        gameEntity.platform = res.getPlatform();
        gameEntity.publisher = res.getPublisher();
        gameEntity.developer = res.getDeveloper();
        gameEntity.releaseDate = res.getReleaseDate();
        gameEntity.freetogameProfileUrl = res.getFreetogameProfileUrl();

        saveGames(gameEntity);
    }

    public void saveGames(GameEntity gameEntity) {
        saveGamesUseCase.saveGame(gameEntity);
    }
}
