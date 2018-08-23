package com.santiago.emparejapps.activities;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import com.santiago.emparejapps.R;
import com.santiago.emparejapps.model.Puntaje;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class JuegoDificilActivity extends AppCompatActivity {
    private TextView nomJ1,nomJ2,puntJ1,puntJ2;
    private ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16;
    private int im1,im2,im3,im4,im5,im6,im7,im8,im9,im10,im11,im12,im13,im14,im15,im16;
    private Integer cartasArray []={11,12,13,14,15,16,17,18, 21,22,23,24,25,26,27,28};
    private MediaPlayer player;
    private Random random=new Random();
    private Chronometer tiempo;
    private int primeraCarta,segundaCarta,primeraSeleccion,segundaSelccion,turno,numeroCarta=1,puntosJ1=0,puntosJ2=0;
    private String nivel="dificil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_dificil);
        inicializar();
        barajarCartas();
        asignarTags();
        cargarParejas();
        tiempo.start();
        int azar=random.nextInt(2);
        if (azar==1){
            turno=1;
            nomJ1.setTextColor(Color.BLACK);
            puntJ1.setTextColor(Color.BLACK);
            nomJ2.setTextColor(Color.GRAY);
            puntJ2.setTextColor(Color.GRAY);
        }else {
            turno=2;
            nomJ1.setTextColor(Color.GRAY);
            puntJ1.setTextColor(Color.GRAY);
            nomJ2.setTextColor(Color.BLACK);
            puntJ2.setTextColor(Color.BLACK);
        }
    }

    private void cargarParejas() {
        im1=R.drawable.i1;
        im2=R.drawable.i2;
        im3=R.drawable.i3;
        im4=R.drawable.i4;
        im5=R.drawable.i5;
        im6=R.drawable.i6;
        im7=R.drawable.i7;
        im8=R.drawable.i8;
        im9=R.drawable.i10;
        im10=R.drawable.i20;
        im11=R.drawable.i30;
        im12=R.drawable.i40;
        im13=R.drawable.i50;
        im14=R.drawable.i60;
        im15=R.drawable.i70;
        im16=R.drawable.i80;

    }

    private void asignarTags() {
        img1.setTag("0");
        img2.setTag("1");
        img3.setTag("2");
        img4.setTag("3");
        img5.setTag("4");
        img6.setTag("5");
        img7.setTag("6");
        img8.setTag("7");
        img9.setTag("8");
        img10.setTag("9");
        img11.setTag("10");
        img12.setTag("11");
        img13.setTag("12");
        img14.setTag("13");
        img15.setTag("14");
        img16.setTag("15");
    }

    private void barajarCartas() {
        Collections.shuffle(Arrays.asList(cartasArray));
    }

    private void inicializar() {
        nomJ1=findViewById(R.id.nombreJ1);
        nomJ2=findViewById(R.id.nomJ2);
        nomJ1.setText(Puntaje.nomJ1);
        nomJ2.setText(Puntaje.nomJ2);
        puntJ1=findViewById(R.id.puntosJ1);
        puntJ2=findViewById(R.id.puntosJ2);
        tiempo=findViewById(R.id.tiempoD);

        img1=findViewById(R.id.imgDificil_1);
        img2=findViewById(R.id.imgDificil_2);
        img3=findViewById(R.id.imgDificil_3);
        img4=findViewById(R.id.imgDificil_4);
        img5=findViewById(R.id.imgDificil_5);
        img6=findViewById(R.id.imgDificil_6);
        img7=findViewById(R.id.imgDificil_7);
        img8=findViewById(R.id.imgDificil_8);
        img9=findViewById(R.id.imgDificil_9);
        img10=findViewById(R.id.imgDificil_10);
        img11=findViewById(R.id.imgDificil_11);
        img12=findViewById(R.id.imgDificil_12);
        img13=findViewById(R.id.imgDificil_13);
        img14=findViewById(R.id.imgDificil_14);
        img15=findViewById(R.id.imgDificil_15);
        img16=findViewById(R.id.imgDificil_16);

    }

    private void habilitarCartas(){
        img1.setEnabled(true);
        img2.setEnabled(true);
        img3.setEnabled(true);
        img4.setEnabled(true);
        img5.setEnabled(true);
        img6.setEnabled(true);
        img7.setEnabled(true);
        img8.setEnabled(true);
        img9.setEnabled(true);
        img10.setEnabled(true);
        img11.setEnabled(true);
        img12.setEnabled(true);
        img13.setEnabled(true);
        img14.setEnabled(true);
        img15.setEnabled(true);
        img16.setEnabled(true);
    }

    private void desabilitarCartas(){
        img1.setEnabled(false);
        img2.setEnabled(false);
        img3.setEnabled(false);
        img4.setEnabled(false);
        img5.setEnabled(false);
        img6.setEnabled(false);
        img7.setEnabled(false);
        img8.setEnabled(false);
        img9.setEnabled(false);
        img10.setEnabled(false);
        img11.setEnabled(false);
        img12.setEnabled(false);
        img13.setEnabled(false);
        img14.setEnabled(false);
        img15.setEnabled(false);
        img16.setEnabled(false);
    }

    private void voltearCartas(){
        img1.setImageResource(R.drawable.no);
        img2.setImageResource(R.drawable.no);
        img3.setImageResource(R.drawable.no);
        img4.setImageResource(R.drawable.no);
        img5.setImageResource(R.drawable.no);
        img6.setImageResource(R.drawable.no);
        img7.setImageResource(R.drawable.no);
        img8.setImageResource(R.drawable.no);
        img9.setImageResource(R.drawable.no);
        img10.setImageResource(R.drawable.no);
        img11.setImageResource(R.drawable.no);
        img12.setImageResource(R.drawable.no);
        img13.setImageResource(R.drawable.no);
        img14.setImageResource(R.drawable.no);
        img15.setImageResource(R.drawable.no);
        img16.setImageResource(R.drawable.no);
    }


    public void imagenSeleccionada(View view) {
    }
}
