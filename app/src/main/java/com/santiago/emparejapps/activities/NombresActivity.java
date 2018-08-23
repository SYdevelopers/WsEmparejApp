package com.santiago.emparejapps.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.santiago.emparejapps.R;
import com.santiago.emparejapps.model.Puntaje;

public class NombresActivity extends AppCompatActivity {

    private TextInputEditText nombreJ1,nombreJ2;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombres);
        nombreJ1=findViewById(R.id.nomJ1);
        nombreJ2=findViewById(R.id.nomJ2);
        btn=findViewById(R.id.btnNext);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Puntaje.nomJ1=nombreJ1.getText().toString();
                Puntaje.nomJ2=nombreJ2.getText().toString();
                Intent intent=new Intent(getApplicationContext(),InicioActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}
