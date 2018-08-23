package com.santiago.emparejapps.activities;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class JuegoConfigActivity extends AppCompatActivity {

     TextView nomJ1,nomJ2,puntJ1,puntJ2,tiempo;
    private ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16;
    private int im1,im2,im3,im4,im5,im6,im7,im8,im9,im10,im11,im12,im13,im14,im15,im16;
    private Integer cartasArray []={11,12,13,14,15,16,17,18, 21,22,23,24,25,26,27,28};
    private MediaPlayer player;
    private Random random=new Random();
    private CountDownTimer downTimer ;
    private int primeraCarta,segundaCarta,primeraSeleccion,segundaSelccion,turno,numeroCarta=1,puntosJ1=0,puntosJ2=0,intentos;
    private String nivel="config";
    long tiempoJuego,mil=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_config);
        inicializar();
        barajarCartas();
        asignarTags();
        cargarParejas();
        Bundle bundle=getIntent().getExtras();
        if (null!=bundle){
            iniciarTiempo(bundle);
        }
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

    private void iniciarTiempo(Bundle bundle) {
        String time=bundle.getString("tiempo");
        tiempoJuego=Long.parseLong(time)*1000;
        downTimer=new CountDownTimer(tiempoJuego,mil) {
            @Override
            public void onTick(long l) {
                int t= (int) (l/mil);
                tiempo.setText(t+"");
            }

            @Override
            public void onFinish() {
                tiempo.setText("0");
                Datos datos=new Datos(JuegoConfigActivity.this);
                Puntaje puntaje=new Puntaje();
                if (puntosJ1>puntosJ2){
                    puntaje.setNombre(nomJ1.getText().toString());
                    puntaje.setPuntos(puntosJ1);
                    puntaje.setNivel(nivel);
                    puntaje.setTiempo(String.valueOf(tiempoJuego));
                    puntaje.setIntentos(intentos);
                }else{
                    puntaje.setNombre(nomJ2.getText().toString());
                    puntaje.setPuntos(puntosJ2);
                    puntaje.setNivel(nivel);
                    puntaje.setTiempo(String.valueOf(tiempoJuego));
                    puntaje.setIntentos(intentos);
                }
                if (datos.guardarPuntajeConfig(puntaje)){
                    Toast.makeText(JuegoConfigActivity.this, "guardo", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(JuegoConfigActivity.this, "no guardo", Toast.LENGTH_SHORT).show();
                }
                String message=nomJ1.getText().toString()+":"+puntosJ1 +"\n"+
                        nomJ2.getText().toString()+":"+puntosJ2 +"\n"+
                        "Tiempo Restante: 0";

                Constantes.dialogo(JuegoConfigActivity.this,message);

            }
        }.start();
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
        nomJ2=findViewById(R.id.nombreJ2);
        nomJ1.setText(Puntaje.nomJ1);
        nomJ2.setText(Puntaje.nomJ2);
        puntJ1=findViewById(R.id.puntosJ1);
        puntJ2=findViewById(R.id.puntosJ2);
        tiempo=findViewById(R.id.tiempoC);

        img1=findViewById(R.id.imgConfig_1);
        img2=findViewById(R.id.imgConfig_2);
        img3=findViewById(R.id.imgConfig_3);
        img4=findViewById(R.id.imgConfig_4);
        img5=findViewById(R.id.imgConfig_5);
        img6=findViewById(R.id.imgConfig_6);
        img7=findViewById(R.id.imgConfig_7);
        img8=findViewById(R.id.imgConfig_8);
        img9=findViewById(R.id.imgConfig_9);
        img10=findViewById(R.id.imgConfig_10);
        img11=findViewById(R.id.imgConfig_11);
        img12=findViewById(R.id.imgConfig_12);
        img13=findViewById(R.id.imgConfig_13);
        img14=findViewById(R.id.imgConfig_14);
        img15=findViewById(R.id.imgConfig_15);
        img16=findViewById(R.id.imgConfig_16);

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
        intentos++;
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
        if (view.getId()==img9.getId()){
            asignarParejas(img9,tag);
        }
        if (view.getId()==img10.getId()){
            asignarParejas(img10,tag);
        }
        if (view.getId()==img11.getId()){
            asignarParejas(img11,tag);
        }
        if (view.getId()==img12.getId()){
            asignarParejas(img12,tag);
        }
        if (view.getId()==img13.getId()){
            asignarParejas(img13,tag);
        }
        if (view.getId()==img14.getId()){
            asignarParejas(img14,tag);
        }
        if (view.getId()==img15.getId()){
            asignarParejas(img15,tag);
        }
        if (view.getId()==img16.getId()){
            asignarParejas(img16,tag);
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
            case 15:img.setImageResource(R.drawable.i5);
                break;
            case 16:img.setImageResource(R.drawable.i6);
                break;
            case 17:img.setImageResource(R.drawable.i7);
                break;
            case 18:img.setImageResource(R.drawable.i8);
                break;
            case 21:img.setImageResource(R.drawable.i10);
                break;
            case 22:img.setImageResource(R.drawable.i20);
                break;
            case 23:img.setImageResource(R.drawable.i30);
                break;
            case 24:img.setImageResource(R.drawable.i40);
                break;
            case 25:img.setImageResource(R.drawable.i50);
                break;
            case 26:img.setImageResource(R.drawable.i60);
                break;
            case 27:img.setImageResource(R.drawable.i70);
                break;
            case 28:img.setImageResource(R.drawable.i80);
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
                case 8:img9.setVisibility(View.INVISIBLE);
                    break;
                case 9:img10.setVisibility(View.INVISIBLE);
                    break;
                case 10:img11.setVisibility(View.INVISIBLE);
                    break;
                case 11:img12.setVisibility(View.INVISIBLE);
                    break;
                case 12:img13.setVisibility(View.INVISIBLE);
                    break;
                case 13:img14.setVisibility(View.INVISIBLE);
                    break;
                case 14:img15.setVisibility(View.INVISIBLE);
                    break;
                case 15:img16.setVisibility(View.INVISIBLE);
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
                case 8:img9.setVisibility(View.INVISIBLE);
                    break;
                case 9:img10.setVisibility(View.INVISIBLE);
                    break;
                case 10:img11.setVisibility(View.INVISIBLE);
                    break;
                case 11:img12.setVisibility(View.INVISIBLE);
                    break;
                case 12:img13.setVisibility(View.INVISIBLE);
                    break;
                case 13:img14.setVisibility(View.INVISIBLE);
                    break;
                case 14:img15.setVisibility(View.INVISIBLE);
                    break;
                case 15:img16.setVisibility(View.INVISIBLE);
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
                img8.getVisibility()==View.INVISIBLE &&
                img9.getVisibility()==View.INVISIBLE &&
                img10.getVisibility()==View.INVISIBLE &&
                img11.getVisibility()==View.INVISIBLE &&
                img12.getVisibility()==View.INVISIBLE &&
                img13.getVisibility()==View.INVISIBLE &&
                img14.getVisibility()==View.INVISIBLE &&
                img15.getVisibility()==View.INVISIBLE &&
                img16.getVisibility()==View.INVISIBLE){

            downTimer.cancel();
            int t = Integer.parseInt(tiempo.getText().toString());
            int timeBD= (int) (tiempoJuego-t);
            Datos datos=new Datos(this);
            Puntaje puntaje=new Puntaje();
            if (puntosJ1>puntosJ2){
                puntaje.setNombre(nomJ1.getText().toString());
                puntaje.setPuntos(puntosJ1);
                puntaje.setNivel(nivel);
                puntaje.setTiempo(String.valueOf(timeBD));
                puntaje.setIntentos(intentos);
            }else{
                puntaje.setNombre(nomJ2.getText().toString());
                puntaje.setPuntos(puntosJ2);
                puntaje.setNivel(nivel);
                puntaje.setTiempo(String.valueOf(timeBD));
                puntaje.setIntentos(intentos);
            }
            if (datos.guardarPuntajeConfig(puntaje)){
                Toast.makeText(this, "guardo", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "no guardo", Toast.LENGTH_SHORT).show();
            }
            String message=nomJ1.getText().toString()+":"+puntosJ1 +"\n"+
                    nomJ2.getText().toString()+":"+puntosJ2 +"\n"+
                    "Tiempo Restante:"+tiempo.getText().toString()+" Seg";

            Constantes.dialogo(this,message);

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        downTimer.cancel();
    }
}
