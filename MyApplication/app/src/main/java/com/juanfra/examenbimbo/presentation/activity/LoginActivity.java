package com.juanfra.examenbimbo.presentation.activity;

import static com.juanfra.examenbimbo.presentation.utils.ToolsKt.getPreference;
import static com.juanfra.examenbimbo.presentation.utils.ToolsKt.savePreferences;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.juanfra.examenbimbo.databinding.ActivityLoginBinding;

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
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
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