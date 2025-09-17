package com.example.juegoxcero;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView[] posiciones;
    boolean turnoX=true;
    boolean turno0=false;
    int[] ids={R.id.img1,R.id.img2, R.id.img3,R.id.img4, R.id.img5, R.id.img6, R.id.img7, R.id.img8, R.id.img9 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        posiciones= new ImageView[9];

        for (int i=0; i<posiciones.length;i++){
            posiciones[i]=findViewById(ids[i]);
        }
        for (int i = 0; i < posiciones.length; i++) {
            final int posicion = i;
            posiciones[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(turnoX){
                        posiciones[posicion].setImageResource(R.drawable.x);
                        turno0=true;
                        turnoX=false;
                    } else if(turno0){
                        posiciones[posicion].setImageResource(R.drawable.cero);
                        turno0=false;
                        turnoX=true;
                    }

                }
            });
        }
       //
    }
}