package com.santiago.emparejapps.activities;

import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.santiago.emparejapps.R;
import com.santiago.emparejapps.data.Constantes;
import com.santiago.emparejapps.data.Datos;

public class PuntajesActivity extends AppCompatActivity {

    private ListView listaFacil,listaNormal,listaDificil,listaConfig;
    private Cursor cursor;
    private SimpleCursorAdapter adapter;
    private Datos datos;
    private String camposBD[]={Constantes.NOMBRE,Constantes.PUNTOS};
    private int camposUI[]={R.id.textView_nombre,R.id.textView_puntajes};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntajes);
        inicializar();
        datos=new Datos(this);
        llenarListaFacil(listaFacil);
        llenarListaNormal(listaNormal);
        llenarListaDificil(listaDificil);
        //llenarListaConfig(listaConfig);
    }

    private void llenarListaFacil(ListView lista) {
        cursor=datos.listarJuegoFacil();
        adapter=new SimpleCursorAdapter(this,R.layout.plantilla_lista,cursor,camposBD,camposUI);
        lista.setAdapter(adapter);
    }
    private void llenarListaNormal(ListView lista) {
        cursor=datos.listarJuegoNormal();
        adapter=new SimpleCursorAdapter(this,R.layout.plantilla_lista,cursor,camposBD,camposUI);
        lista.setAdapter(adapter);
    }
    private void llenarListaDificil(ListView lista) {
        cursor=datos.listarJuegoDificil();
        adapter=new SimpleCursorAdapter(this,R.layout.plantilla_lista,cursor,camposBD,camposUI);
        lista.setAdapter(adapter);
    }
//    private void llenarListaConfig(ListView lista) {
//        cursor=datos.listarJuegoConfig();
//
//        adapter=new SimpleCursorAdapter(this,R.layout.plantilla_lista,cursor,camposBD,camposUI);
//        lista.setAdapter(adapter);
//    }

    private void inicializar() {
        listaFacil=findViewById(R.id.lista_facil);
        listaNormal=findViewById(R.id.lista_medio);
        listaDificil=findViewById(R.id.lista_dificil);
        listaConfig=findViewById(R.id.lista_configuracion);
    }
}
