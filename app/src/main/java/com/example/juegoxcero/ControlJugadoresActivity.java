package com.example.juegoxcero;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ControlJugadoresActivity extends AppCompatActivity {

    private TextView tvNombre1, tvNombre2;
    private Button btn1X, btn1O, btn2X, btn2O;

    private JugadorPrefs prefs;
    private Jugador jugador1, jugador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_jugadores);

        prefs       = new JugadorPrefs(this);
        jugador1    = prefs.obtenerJugador(1);
        jugador2    = prefs.obtenerJugador(2);

        tvNombre1 = findViewById(R.id.tvNombre1);
        tvNombre2 = findViewById(R.id.tvNombre2);
        btn1X     = findViewById(R.id.btn1X);
        btn1O     = findViewById(R.id.btn1O);
        btn2X     = findViewById(R.id.btn2X);
        btn2O     = findViewById(R.id.btn2O);

        tvNombre1.setText(jugador1.getNombre());
        tvNombre2.setText(jugador2.getNombre());

        // Configurar listeners
        btn1X.setOnClickListener(v -> {
            jugador1.setSimboloAsignado("X");
            prefs.guardarJugador(1, jugador1);
            Toast.makeText(
                    this,
                    jugador1.getNombre() +
                            " asignado X. Victorias con X: " +
                            jugador1.getVictoriasX(),
                    Toast.LENGTH_SHORT
            ).show();
            actualizarBotones();
        });

        btn1O.setOnClickListener(v -> {
            jugador1.setSimboloAsignado("0");
            prefs.guardarJugador(1, jugador1);
            Toast.makeText(
                    this,
                    jugador1.getNombre() +
                            " asignado 0. Victorias con O: " +
                            jugador1.getVictoriasO(),
                    Toast.LENGTH_SHORT
            ).show();
            actualizarBotones();
        });

        btn2X.setOnClickListener(v -> {
            jugador2.setSimboloAsignado("X");
            prefs.guardarJugador(2, jugador2);
            Toast.makeText(
                    this,
                    jugador2.getNombre() +
                            " asignado X. Victorias con X: " +
                            jugador2.getVictoriasX(),
                    Toast.LENGTH_SHORT
            ).show();
            actualizarBotones();
        });

        btn2O.setOnClickListener(v -> {
            jugador2.setSimboloAsignado("0");
            prefs.guardarJugador(2, jugador2);
            Toast.makeText(
                    this,
                    jugador2.getNombre() +
                            " asignado 0. Victorias con O: " +
                            jugador2.getVictoriasO(),
                    Toast.LENGTH_SHORT
            ).show();
            actualizarBotones();
        });

        // Deshabilita el botón del símbolo ya asignado
        actualizarBotones();
    }

    private void actualizarBotones() {
        // Jugador 1
        btn1X.setEnabled(!"X".equals(jugador1.getSimboloAsignado()));
        btn1O.setEnabled(!"0".equals(jugador1.getSimboloAsignado()));
        // Jugador 2
        btn2X.setEnabled(!"X".equals(jugador2.getSimboloAsignado()));
        btn2O.setEnabled(!"0".equals(jugador2.getSimboloAsignado()));
    }
}
