package com.santiago.emparejapps.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.santiago.emparejapps.R;

public class NivelesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles);
    }

    public void jugar(View view) {
        switch (view.getId()){
            case R.id.btnFacil:
                startActivity(new Intent(this,JuegoFacilActivity.class));
                break;
            case R.id.btnNormal:
                startActivity(new Intent(this,JuegoNormalActivity.class));
                break;

            case R.id.btnDificil:
                startActivity(new Intent(this,JuegoDificilActivity.class));
                break;


        }
    }
}
