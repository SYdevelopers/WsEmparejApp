package com.santiago.emparejapps.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.santiago.emparejapps.R;

public class ConfiguracionActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText tiempo;
    private Button jugar;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        tiempo=findViewById(R.id.txtTiempo);
        jugar=findViewById(R.id.btnJugarConfig);
        preferences=getSharedPreferences("tiempoJuego",MODE_PRIVATE);
        jugar.setOnClickListener(this);
        cargarPreferences();

    }

    private void cargarPreferences() {
       String time= preferences.getString("tiempo",null);
        if (preferences!=null){
            tiempo.setText(time);
        }
    }

    @Override
    public void onClick(View view) {
        if (tiempo.getText().toString().isEmpty()){
            Toast.makeText(this, "debe ingresar el tiempo maximo de juego", Toast.LENGTH_SHORT).show();
        }else {
            guardarPreferences();
            Intent intent=new Intent(this,JuegoConfigActivity.class);
            intent.putExtra("tiempo",tiempo.getText().toString());
            startActivity(intent);
        }

    }

    private void guardarPreferences() {
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("tiempo",tiempo.getText().toString());
        editor.apply();
    }
}
