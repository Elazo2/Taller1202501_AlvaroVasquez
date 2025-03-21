package com.example.taller1202501;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.graphics.Color;
import java.util.Random;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText c1;
    private TextView t1;
    private Spinner spinnerFuentes;
    private int tamano = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        c1 = findViewById(R.id.caja1);
        t1 = findViewById(R.id.texto1);
        spinnerFuentes = findViewById(R.id.spinner); //


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.fuentes, android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFuentes.setAdapter(adapter);

        spinnerFuentes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String fuenteSeleccionada = parent.getItemAtPosition(position).toString();
                t1.setTypeface(Typeface.create(fuenteSeleccionada, Typeface.NORMAL));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Incrementar(View view) {
        String cadena = c1.getText().toString();
        t1.setText(cadena);

        if (tamano < 60) {
            tamano += 8;
        }

        t1.setTextSize(tamano);
    }
    public void CambiarColor(View view) {
        Random random = new Random();
        int colorAleatorio = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        t1.setTextColor(colorAleatorio);
    }
    public void Decrementar(View view) {
        String cadena = c1.getText().toString();
        t1.setText(cadena);

        if (tamano > 8) {
            tamano -= 8;
        }

        t1.setTextSize(tamano);
    }
}
