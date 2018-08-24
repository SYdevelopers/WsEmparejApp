package com.santiago.emparejapps.data;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.BaseColumns;
import android.support.v7.app.AlertDialog;


public class Constantes implements BaseColumns {
    public final static String TBL_PUNTAJES="puntajes";
    public final static String TBL_CONFIGURACION="configuracion";
    public final static String NOMBRE="nombre";
    public final static String PUNTOS="puntos";

    public final static String NIVEL="nivel";
    public final static String TIEMPO="tiempo";
    public final static String INTENTOS="intentos";


    //metodo para crear la tabla de putajes
    public static String SQL_QUERY="CREATE TABLE "+TBL_PUNTAJES+"("+
            _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            NOMBRE + " TEXT,"+
            PUNTOS + " INTEGER,"+
            NIVEL + " TEXT,"+
            TIEMPO + " TEXT)";

    //metodo para crear la tabla de configuracion
    public static String SQL_QUERY_CONFIG="CREATE TABLE "+ TBL_CONFIGURACION+"("+
            _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            NOMBRE + " TEXT,"+
            PUNTOS + " INTEGER,"+
            TIEMPO + " INTEGER,"+
            INTENTOS + " INTEGER)";




    //metodo que nos permite crear los dialogos
    public static void dialogo(final Activity activity, final String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(activity);
        builder.setTitle("Resultados")
                .setMessage(message)
                .setNegativeButton("twitter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_TEXT,"Resultados: \n"+message);
                        intent.setType("text/plain");
                        intent.setPackage("com.twitter.android");
                        activity.startActivity(intent);
                        activity.onBackPressed();
                    }
                })
                .setNeutralButton("Terminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        activity.finish();
                    }
                })
                .setPositiveButton("facebook", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_TEXT,message);
                        intent.setType("text/plain");
                        intent.setPackage("com.facebook.katana");
                        activity.startActivity(intent);
                        activity.onBackPressed();

                    }
                })
                .setCancelable(false);
        AlertDialog dialog=builder.create();
        dialog.show();
    }


}
