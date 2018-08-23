package com.santiago.emparejapps.data;

import android.provider.BaseColumns;

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
            Constantes.TIEMPO + " INTEGER)";

}
