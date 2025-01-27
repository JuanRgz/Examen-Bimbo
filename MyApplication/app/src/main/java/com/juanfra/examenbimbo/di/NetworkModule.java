package com.juanfra.examenbimbo.di;

import static com.juanfra.examenbimbo.data.network.ApiConstants.BASE_URL;

import com.juanfra.examenbimbo.data.network.GameService;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@InstallIn(SingletonComponent.class)
@Module
public class NetworkModule {
    @Provides
    public Retrofit provideRetrofit(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        OkHttpClient client = httpClient.build();
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    public GameService provideGameService(Retrofit retrofit){
        return retrofit.create(GameService.class);
    }
}
