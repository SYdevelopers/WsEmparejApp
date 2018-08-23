package com.santiago.emparejapps.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.santiago.emparejapps.R;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    public void next(View view) {
        switch (view.getId()){
            case R.id.btnJugar:
                startActivity(new Intent(this,NivelesActivity.class));
                break;
            case R.id.btnConfig:
                startActivity(new Intent(this,ConfiguracionActivity.class));
                break;
            case R.id.btnPuntaje:
                startActivity(new Intent(this,PuntajesActivity.class));
                break;
        }
    }
}
