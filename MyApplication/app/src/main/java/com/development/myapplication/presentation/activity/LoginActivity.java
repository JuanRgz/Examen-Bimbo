package com.development.myapplication.presentation.activity;

import static com.development.myapplication.presentation.activity.utils.ToolsKt.getPreference;
import static com.development.myapplication.presentation.activity.utils.ToolsKt.savePreferences;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.development.myapplication.R;
import com.development.myapplication.databinding.ActivityLoginBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        String name = getUserName();

        if(!name.isEmpty()){
            bind.etName.setText(name);
        }

        bind.btnContinue.setOnClickListener(v -> {
            String save = bind.etName.getText().toString();
            if(!save.isEmpty()){
                bind.pbLoading.setVisibility(View.VISIBLE);
                savePreferences(this, save);
                try{Sleep();}
                catch (InterruptedException e){
                    e.toString();
                }
                bind.pbLoading.setVisibility(View.GONE);
            }
        });
    }

    private void Sleep() throws InterruptedException {
        Thread.sleep(2000);
    }

    private String getUserName() {
        return getPreference(this);
    }
}