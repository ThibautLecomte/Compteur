package com.example.cdsm.compteur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class Settings extends AppCompatActivity {

    SeekBar bar1;
    SeekBar bar2;
    Button bouton;
    int debut;
    int limite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        bar1 = (SeekBar)findViewById(R.id.seekBar);
        bar2 = (SeekBar)findViewById(R.id.seekBar2);
        bouton = (Button)findViewById(R.id.button3);




        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                debut = bar1.getProgress();
                limite = bar2.getProgress();
                Log.i("    Debut la !!!!! :   ", String.valueOf(debut));
                Log.i("  Limite la !!!!! :   ", String.valueOf(limite));

                Intent intent = new Intent();
                intent.putExtra("Debut", debut);
                intent.putExtra("Limite", limite);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
