package com.juanfra.examenbimbo.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.juanfra.examenbimbo.databinding.ActivityMainBinding;
import com.juanfra.examenbimbo.presentation.adapter.ListAdapter;
import com.juanfra.examenbimbo.presentation.utils.OnClickList;
import com.juanfra.examenbimbo.presentation.viewmodel.ListViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements OnClickList {

    ActivityMainBinding bind;
    ListViewModel viewModel;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        viewModel = new ViewModelProvider(this).get(ListViewModel.class);
        adapter = new ListAdapter(this);
        bind.rvGames.setLayoutManager(new GridLayoutManager(this, 2));
        bind.rvGames.setAdapter(adapter);
        bind.pbLoading.setVisibility(View.VISIBLE);
        viewModel.getGames();

        viewModel.resultsLiveData.observe(this, data -> {
            adapter.addData(data);
            bind.pbLoading.setVisibility(View.GONE);
        });
        viewModel.errorLiveData.observe(this, error -> {
            viewModel.fetchGames();
        });

        viewModel.gameLiveData.observe(this, s-> {
            if(s.isEmpty()){
                viewModel.getGames();
            } else{
                adapter.addData(s);
                bind.pbLoading.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void goToView(String result, View view) {
        String res = new Gson().toJson(result);
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra("game",result);
        startActivity(i);
    }
}