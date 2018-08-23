package com.santiago.emparejapps.data;

import android.app.Activity;
import android.content.DialogInterface;
import android.provider.BaseColumns;
import android.support.v7.app.AlertDialog;

public class Constantes implements BaseColumns {
    public final static String TBL_PUNTAJES="puntajes";
    public final static String NOMBRE="nombre";
    public final static String PUNTOS="puntos";
    public final static String NIVEL="nivel";
    public final static String TIEMPO="tiempo";


    public static String SQL_QUERY="CREATE TABLE "+ Constantes.TBL_PUNTAJES+"("+
            Constantes._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            Constantes.NOMBRE + " TEXT,"+
            Constantes.PUNTOS + " INTEGER,"+
            Constantes.NIVEL + " TEXT,"+
            Constantes.TIEMPO + " TEXT)";

    public static void dialogo(final Activity activity, String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(activity);
        builder.setTitle("Resultados")
                .setMessage(message)
                .setNegativeButton("Terminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        activity.finish();
                    }
                })
                .setNeutralButton("twitter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("facebook", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setCancelable(false);
        AlertDialog dialog=builder.create();
        dialog.show();
    }

}
