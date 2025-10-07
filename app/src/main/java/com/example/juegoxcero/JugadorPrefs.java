// JugadorPrefs.java
package com.example.juegoxcero;

import android.content.Context;
import android.content.SharedPreferences;

public class JugadorPrefs {
    private static final String PREFS_NAME      = "jugadores_prefs";
    private static final String KEY_NOMBRE      = "nombre_";      // + index
    private static final String KEY_VX          = "vict_x_";      // + index
    private static final String KEY_VO          = "vict_o_";      // + index
    private static final String KEY_SIMBOLO     = "simbolo_";     // + index

    private SharedPreferences prefs;

    public JugadorPrefs(Context ctx) {
        prefs = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void guardarJugador(int index, Jugador j) {
        SharedPreferences.Editor ed = prefs.edit();
        ed.putString(KEY_NOMBRE + index, j.getNombre());
        ed.putInt(KEY_VX + index, j.getVictoriasX());
        ed.putInt(KEY_VO + index, j.getVictoriasO());
        ed.putString(KEY_SIMBOLO + index, j.getSimboloAsignado());
        ed.apply();
    }

    public Jugador obtenerJugador(int index) {
        String nombre = prefs.getString(KEY_NOMBRE + index, "Jugador " + index);
        int vx       = prefs.getInt(KEY_VX + index, 0);
        int vo       = prefs.getInt(KEY_VO + index, 0);
        String sim   = prefs.getString(KEY_SIMBOLO + index, "");
        return new Jugador(nombre, vx, vo, sim);
    }
}
