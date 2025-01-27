package com.juanfra.examenbimbo.data.network;

import static com.juanfra.examenbimbo.data.network.ApiConstants.GAMES;
import com.juanfra.examenbimbo.domain.model.GamesResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface GameService {
    @GET(GAMES)
    Observable<GamesResponse> getGames();
}