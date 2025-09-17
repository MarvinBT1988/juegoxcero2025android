package com.example.juegoxcero;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import java.util.Objects;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {
    ImageView[] posiciones;
    String[] posicionesLlenas;
    boolean turnoX=true;
    boolean turno0=false;
    boolean estatusJuego=true;
    ImageView imagenTurno;
    int marcadorX, marcador0=0;
    int[] ids={R.id.img1,R.id.img2, R.id.img3,R.id.img4, R.id.img5, R.id.img6, R.id.img7, R.id.img8, R.id.img9 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        posiciones= new ImageView[9];
        posicionesLlenas=new String[9];
        Button btnReniciar=findViewById(R.id.btnIniciar);
        imagenTurno=findViewById(R.id.imgTurno);
        btnReniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarJuego();
            }
        });
        for (int i=0; i<posiciones.length;i++){
            posiciones[i]=findViewById(ids[i]);
        }
        for (int i = 0; i < posiciones.length; i++) {
            final int posicion = i;
            posiciones[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    logicaTurno(posicion);
                }
            });
        }
        iniciarJuego();
        Button btnRegla = findViewById(R.id.btnRegla);
        btnRegla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReglaJuegoActividad.class);
                startActivity(intent);
            }
        });
        Button btnResultado = findViewById(R.id.btnResultados);
        btnResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
                intent.putExtra("marcadorX", marcadorX);
                intent.putExtra("marcador0", marcador0);
                startActivity(intent);
            }
        });
       //
    }
    private void iniciarJuego(){
        inicioAleatorio();
        estatusJuego=true;
        for (int i=0; i<posiciones.length;i++){
            posiciones[i].setImageResource(R.drawable.vacio);
            posicionesLlenas[i]="";
        }
    }
    private void logicaTurno(int posicion){
        if(estatusJuego) {
            if (Objects.equals(posicionesLlenas[posicion], "")) {
                if (turnoX) {
                    posiciones[posicion].setImageResource(R.drawable.x);
                    turno0 = true;
                    turnoX = false;
                    posicionesLlenas[posicion] = "X";
                    boolean gano=verificarGanador("X");
                    if(gano){
                        felicitarGanador("El jugador con la X ganó la partida.");
                        marcadorX++;
                    }
                    else{
                        verficicarEmpate();
                    }
                    if(estatusJuego){
                        imagenTurno.setImageResource(R.drawable.cero);
                    }
                } else if (turno0) {
                    posiciones[posicion].setImageResource(R.drawable.cero);
                    turno0 = false;
                    turnoX = true;
                    posicionesLlenas[posicion] = "0";
                    boolean gano=verificarGanador("0");
                    if(gano){
                        felicitarGanador("El jugador con el 0 ganó la partida.");
                        marcador0++;
                    }
                    else{
                        verficicarEmpate();
                    }
                    if(estatusJuego){
                        imagenTurno.setImageResource(R.drawable.x);
                    }
                }
            } else {
                Toast.makeText(this, "¡Seleccione una casilla vacia!", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "La partida ha terminado.", Toast.LENGTH_SHORT).show();
        }

    }
    private void felicitarGanador(String mesaje){
        Toast.makeText(this, mesaje, Toast.LENGTH_SHORT).show();
        estatusJuego=false;
    }
    private  void verficicarEmpate(){
        if(estatusJuego){
            boolean empate=true;
            for(int i=0;i<posicionesLlenas.length;i++){
                if (Objects.equals(posicionesLlenas[i], "")) {
                    empate=false;
                }
            }
            if(empate){
                Toast.makeText(this, "El juego terminó en un empate.", Toast.LENGTH_SHORT).show();
                estatusJuego=false;
            }
        }
    }
    private boolean verificarGanador(String tipoJuegador){
        boolean result=false;
        // verificar horizontal
        if(Objects.equals(posicionesLlenas[0], tipoJuegador) &&
                Objects.equals(posicionesLlenas[1], tipoJuegador) &&
                Objects.equals(posicionesLlenas[2], tipoJuegador)){
            result=true;
        }
        else if(Objects.equals(posicionesLlenas[3], tipoJuegador) &&
                Objects.equals(posicionesLlenas[4], tipoJuegador) &&
                Objects.equals(posicionesLlenas[5], tipoJuegador)){
            result=true;
        }
        else if(Objects.equals(posicionesLlenas[6], tipoJuegador) &&
                Objects.equals(posicionesLlenas[7], tipoJuegador) &&
                Objects.equals(posicionesLlenas[8], tipoJuegador)){
            result=true;
        }
        // verificar vertical
        else if(Objects.equals(posicionesLlenas[0], tipoJuegador) &&
                Objects.equals(posicionesLlenas[3], tipoJuegador) &&
                Objects.equals(posicionesLlenas[6], tipoJuegador)){
            result=true;
        }
        else if(Objects.equals(posicionesLlenas[1], tipoJuegador) &&
                Objects.equals(posicionesLlenas[4], tipoJuegador) &&
                Objects.equals(posicionesLlenas[7], tipoJuegador)){
            result=true;
        }
        else if(Objects.equals(posicionesLlenas[2], tipoJuegador) &&
                Objects.equals(posicionesLlenas[5], tipoJuegador) &&
                Objects.equals(posicionesLlenas[8], tipoJuegador)){
            result=true;
        }
        // verificar diagonal
        else if(Objects.equals(posicionesLlenas[0], tipoJuegador) &&
                Objects.equals(posicionesLlenas[4], tipoJuegador) &&
                Objects.equals(posicionesLlenas[8], tipoJuegador)){
            result=true;
        }
        else if(Objects.equals(posicionesLlenas[2], tipoJuegador) &&
                Objects.equals(posicionesLlenas[4], tipoJuegador) &&
                Objects.equals(posicionesLlenas[6], tipoJuegador)){
            result=true;
        }
        return result;
    }
    private void inicioAleatorio(){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(2);
        if(numeroAleatorio==1){
             turnoX=true;
             turno0=false;
            imagenTurno.setImageResource(R.drawable.x);
        }
        else{
             turnoX=false;
             turno0=true;
            imagenTurno.setImageResource(R.drawable.cero);
        }
    }
}