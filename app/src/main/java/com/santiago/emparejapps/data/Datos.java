package com.santiago.emparejapps.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
        sqLiteDatabase.execSQL(Constantes.SQL_QUERY_CONFIG);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Constantes.TBL_PUNTAJES);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Constantes.TBL_CONFIGURACION);
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

    public boolean guardarPuntajeConfig(Puntaje puntaje){
        db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Constantes.NOMBRE,puntaje.getNombre());
        values.put(Constantes.PUNTOS,puntaje.getPuntos());
        values.put(Constantes.TIEMPO,puntaje.getTiempo());
        values.put(Constantes.INTENTOS,puntaje.getIntentos());
        return db.insert(Constantes.TBL_CONFIGURACION,null,values)>0;
    }

    public Cursor listarJuegoFacil(){
        db=getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+Constantes.TBL_PUNTAJES + " WHERE "+ Constantes.NIVEL+
                                    "="+ "'facil'"+ " ORDER BY "+ Constantes.PUNTOS+ " DESC LIMIT 0,5",null );
        if (cursor.moveToFirst()){
            return cursor;
        }else {
            return null;
        }
    }


    public Cursor listarJuegoNormal(){
        db=getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+Constantes.TBL_PUNTAJES + " WHERE "+ Constantes.NIVEL+
                "="+ "'normal'"+ " ORDER BY "+ Constantes.PUNTOS+ " DESC LIMIT 0,5",null );
        if (cursor.moveToFirst()){
            return cursor;
        }else {
            return null;
        }
    }


    public Cursor listarJuegoDificil(){
        db=getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+Constantes.TBL_PUNTAJES + " WHERE "+ Constantes.NIVEL+
                "="+ "'dificil'"+ " ORDER BY "+ Constantes.PUNTOS+ " DESC LIMIT 0,5",null );
        if (cursor.moveToFirst()){
            return cursor;
        }else {
            return null;
        }
    }


    public Cursor listarJuegoConfig(){
        db=getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+Constantes.TBL_CONFIGURACION+ " ORDER BY "+ Constantes.PUNTOS+ " DESC LIMIT 0,5",null );
        if (cursor.moveToFirst()){
            return cursor;
        }else {
            return null;
        }
    }
}
