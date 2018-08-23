package com.santiago.emparejapps.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.santiago.emparejapps.model.Puntaje;

public class Datos extends SQLiteOpenHelper {
    SQLiteDatabase db;
    public Datos(Context context) {
        super(context, "Emparej.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Constantes.SQL_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Constantes.TBL_PUNTAJES);
        onCreate(sqLiteDatabase);
    }

    public boolean guardarPuntaje(Puntaje puntaje){
        db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Constantes.NOMBRE,puntaje.getNombre());
        values.put(Constantes.PUNTOS,puntaje.getPuntos());
        values.put(Constantes.NIVEL,puntaje.getNivel());
        values.put(Constantes.TIEMPO,puntaje.getTiempo());
        return db.insert(Constantes.TBL_PUNTAJES,null,values)>0;
    }
}
