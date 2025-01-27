package com.juanfra.examenbimbo.presentation.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.juanfra.examenbimbo.R;
import com.juanfra.examenbimbo.databinding.ActivityDetailBinding;
import com.juanfra.examenbimbo.domain.model.GameModel;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        Intent intent = getIntent();

        String getGame = intent.getStringExtra("game");
        GameModel game = new Gson().fromJson(getGame, GameModel.class);

        Glide.with(this).load(game.getThumbnail()).into(bind.ivLogo);
        bind.title.setText(game.getTitle());
        bind.description.setText(game.getShortDescription());
        bind.developer.setText(game.getDeveloper());
        bind.genre.setText(game.getGenre());
        bind.platform.setText(game.getPlatform());
        bind.publisher.setText(game.getPublisher());

    }
}