package com.example.juegoxcero;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
public class ResultadoActivity extends AppCompatActivity {
    TextView txtMarcadorX, txtMarcadorO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activityresultados);
        Intent intent = getIntent();
        int marcadorX = intent.getIntExtra("marcadorX", 0);
        int marcador0 = intent.getIntExtra("marcador0", 0);
        txtMarcadorX=findViewById(R.id.txtMarcadorX);
        txtMarcadorO=findViewById(R.id.txtMarcador0);
        txtMarcadorX.setText(String.valueOf(marcadorX));
        txtMarcadorO.setText(String.valueOf(marcador0));
        Button btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
