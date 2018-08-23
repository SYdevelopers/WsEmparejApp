package com.santiago.emparejapps.activities;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.santiago.emparejapps.R;
import com.santiago.emparejapps.data.Constantes;
import com.santiago.emparejapps.data.Datos;
import com.santiago.emparejapps.model.Puntaje;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class JuegoFacilActivity extends AppCompatActivity {
    private TextView nomJ1,nomJ2,puntJ1,puntJ2;
    private ImageView img1,img2,img3,img4,img5,img6,img7,img8;
    private int im1,im2,im3,im4,im5,im6,im7,im8;
    private Integer cartasArray []={11,12,13,14, 21,22,23,24};
    private MediaPlayer player;
    private Random random=new Random();
    private Chronometer tiempo;
    private int primeraCarta,segundaCarta,primeraSeleccion,segundaSelccion,turno,numeroCarta=1,puntosJ1=0,puntosJ2=0;
    private String nivel="facil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_normal);
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
        im5=R.drawable.i10;
        im6=R.drawable.i20;
        im7=R.drawable.i30;
        im8=R.drawable.i40;



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

    }

    private void barajarCartas() {
        Collections.shuffle(Arrays.asList(cartasArray));
    }

    private void inicializar() {
        nomJ1=findViewById(R.id.nombreJ1);
        nomJ2=findViewById(R.id.nombreJ2);
        nomJ1.setText(Puntaje.nomJ1);
        nomJ2.setText(Puntaje.nomJ2);
        puntJ1=findViewById(R.id.puntosJ1);
        puntJ2=findViewById(R.id.puntosJ2);
        tiempo=findViewById(R.id.tiempoF);

        img1=findViewById(R.id.imgFacil_1);
        img2=findViewById(R.id.imgFacil_2);
        img3=findViewById(R.id.imgFacil_3);
        img4=findViewById(R.id.imgFacil_4);
        img5=findViewById(R.id.imgFacil_5);
        img6=findViewById(R.id.imgFacil_6);
        img7=findViewById(R.id.imgFacil_7);
        img8=findViewById(R.id.imgFacil_8);

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

    }

    public void imagenSeleccionada(View view) {
        int tag =Integer.parseInt((String) view.getTag());
        if (view.getId()==img1.getId()){
            asignarParejas(img1,tag);
        }
        if (view.getId()==img2.getId()){
            asignarParejas(img2,tag);
        }
        if (view.getId()==img3.getId()){
            asignarParejas(img3,tag);
        }
        if (view.getId()==img4.getId()){
            asignarParejas(img4,tag);
        }
        if (view.getId()==img5.getId()){
            asignarParejas(img5,tag);
        }
        if (view.getId()==img6.getId()){
            asignarParejas(img6,tag);
        }
        if (view.getId()==img7.getId()){
            asignarParejas(img7,tag);
        }
        if (view.getId()==img8.getId()){
            asignarParejas(img8,tag);
        }

    }

    private void asignarParejas(ImageView img, int tag) {
        switch (cartasArray[tag]){
            case 11:img.setImageResource(R.drawable.i1);
                break;
            case 12:img.setImageResource(R.drawable.i2);
                break;
            case 13:img.setImageResource(R.drawable.i3);
                break;
            case 14:img.setImageResource(R.drawable.i4);
                break;
            case 21:img.setImageResource(R.drawable.i10);
                break;
            case 22:img.setImageResource(R.drawable.i20);
                break;
            case 23:img.setImageResource(R.drawable.i30);
                break;
            case 24:img.setImageResource(R.drawable.i40);
                break;
        }
        if (numeroCarta==1){
            primeraCarta=cartasArray[tag];
            if (primeraCarta>20){
                primeraCarta=primeraCarta-10;
            }
            numeroCarta=2;
            img.setEnabled(false);
            primeraSeleccion=tag;
        }else if (numeroCarta==2){
            segundaCarta=cartasArray[tag];
            if (segundaCarta>20){
                segundaCarta=segundaCarta-10;
            }
            numeroCarta=1;
            desabilitarCartas();
            segundaSelccion=tag;

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    verificarSelccion();
                }
            },1000);

        }
    }

    private void verificarSelccion() {
        if (primeraCarta==segundaCarta){
            player=MediaPlayer.create(this,R.raw.win);
            player.start();

            switch (primeraSeleccion){
                case 0:img1.setVisibility(View.INVISIBLE);
                    break;
                case 1:img2.setVisibility(View.INVISIBLE);
                    break;
                case 2:img3.setVisibility(View.INVISIBLE);
                    break;
                case 3:img4.setVisibility(View.INVISIBLE);
                    break;
                case 4:img5.setVisibility(View.INVISIBLE);
                    break;
                case 5:img6.setVisibility(View.INVISIBLE);
                    break;
                case 6:img7.setVisibility(View.INVISIBLE);
                    break;
                case 7:img8.setVisibility(View.INVISIBLE);
                    break;

            }

            switch (segundaSelccion){
                case 0:img1.setVisibility(View.INVISIBLE);
                    break;
                case 1:img2.setVisibility(View.INVISIBLE);
                    break;
                case 2:img3.setVisibility(View.INVISIBLE);
                    break;
                case 3:img4.setVisibility(View.INVISIBLE);
                    break;
                case 4:img5.setVisibility(View.INVISIBLE);
                    break;
                case 5:img6.setVisibility(View.INVISIBLE);
                    break;
                case 6:img7.setVisibility(View.INVISIBLE);
                    break;
                case 7:img8.setVisibility(View.INVISIBLE);
                    break;

            }
            if (turno==1){
                puntosJ1=puntosJ1+100;
                puntJ1.setText(puntosJ1+"");
            }else if (turno==2){
                puntosJ2=puntosJ2+100;
                puntJ2.setText(puntosJ2+"");
            }

        }else{
            player=MediaPlayer.create(this,R.raw.lose);
            player.start();
            voltearCartas();
            if (turno==1){
                turno=2;
                puntosJ1=puntosJ1-2;
                if (puntosJ1<=0){
                    puntosJ1=0;
                }
                puntJ1.setText(puntosJ1+"");
                nomJ1.setTextColor(Color.GRAY);
                puntJ1.setTextColor(Color.GRAY);
                nomJ2.setTextColor(Color.BLACK);
                puntJ2.setTextColor(Color.BLACK);
            }else if (turno==2){
                turno=1;
                puntosJ2=puntosJ2-2;
                if (puntosJ2<=0){
                    puntosJ2=0;
                }
                puntJ2.setText(puntosJ2+"");
                nomJ1.setTextColor(Color.BLACK);
                puntJ1.setTextColor(Color.BLACK);
                nomJ2.setTextColor(Color.GRAY);
                puntJ2.setTextColor(Color.GRAY);
            }
        }
        habilitarCartas();
        verificarUltimaCarta();
    }

    private void verificarUltimaCarta() {
        if (img1.getVisibility()==View.INVISIBLE &&
                img2.getVisibility()==View.INVISIBLE &&
                img3.getVisibility()==View.INVISIBLE &&
                img4.getVisibility()==View.INVISIBLE &&
                img5.getVisibility()==View.INVISIBLE &&
                img6.getVisibility()==View.INVISIBLE &&
                img7.getVisibility()==View.INVISIBLE &&
                img8.getVisibility()==View.INVISIBLE){
            tiempo.stop();
            Datos datos=new Datos(this);
            Puntaje puntaje=new Puntaje();
            if (puntosJ1>puntosJ2){
                puntaje.setNombre(nomJ1.getText().toString());
                puntaje.setPuntos(puntosJ1);
                puntaje.setNivel(nivel);
                puntaje.setTiempo(tiempo.getText().toString());
            }else{
                puntaje.setNombre(nomJ2.getText().toString());
                puntaje.setPuntos(puntosJ2);
                puntaje.setNivel(nivel);
                puntaje.setTiempo(tiempo.getText().toString());
            }
            if (datos.guardarPuntaje(puntaje)){
                Toast.makeText(this, "guardo", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "no guardo", Toast.LENGTH_SHORT).show();
            }
            String message=nomJ1.getText().toString()+":"+puntosJ1 +"\n"+
                    nomJ2.getText().toString()+":"+puntosJ2 +"\n"+
                    "Tiempo:"+tiempo.getText().toString();

            Constantes.dialogo(this,message);

        }

    }
}
