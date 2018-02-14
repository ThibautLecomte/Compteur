package com.example.cdsm.compteur;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textview;
    CompteurADAL UnCpt;
    Digit[] Compteur;



    int limite = 5000;
    int debut = 4950;

    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        textview = (TextView)findViewById(R.id.textView);


        UnCpt = new CompteurADAL(4, debut, limite);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 timer = new CountDownTimer(50000, 10) {
                        public void onTick(long millisUntilFinished) {


                            UnCpt.Incrementer();
                            Compteur = UnCpt.getCompteur();
                            String chaine = "";
                            for (int i = 0; i < 4; i++) {
                                chaine = chaine + String.valueOf(Compteur[i].getValeur());
                            }

                            textview.setText(chaine);
                            if(UnCpt.GetLampe()){
                                timer.cancel();
                                textview.setText("Fini !!!");


                            }
                        }public void onFinish(){

                        }

                    }.start();
                }

        });

    }
}
