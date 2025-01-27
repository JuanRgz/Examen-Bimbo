package com.juanfra.examenbimbo.presentation.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

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
        bind.rvGames.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        bind.rvGames.setAdapter(adapter);
        viewModel.fetchGames();

        viewModel.resultsLiveData.observe(this, data -> {
            adapter.addData(data);
        });
        viewModel.errorLiveData.observe(this, error -> {
            Toast.makeText(this, "Error " + error, Toast.LENGTH_SHORT).show();
        });

        viewModel.gameLiveData.observe(this, s-> {
            if(s.isEmpty()){
                viewModel.getGames();
            } else{
                adapter.addData(s);
            }
        });
    }

    @Override
    public void goToView(Object result, View view) {

    }
}