package com.example.pw.rollenspiel;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by PW on 29.01.17.
 */
public class ActivityTwo_Geradeaus extends AppCompatActivity {

    // Layout variables
    TextView tvCounter;
    EditText etEingabe;
    Button bBestaetigen;

    // Other variables
    int height = 157;
    boolean isHeightCorrect = false;
    Thread threadCounter;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_geradeaus);

        tvCounter = (TextView) findViewById(R.id.tvCounter);
        etEingabe = (EditText) findViewById(R.id.etEingabe);
        bBestaetigen = (Button) findViewById(R.id.bBestaetigen);

        bBestaetigen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eingabe = etEingabe.getText().toString();
                int eingabeHeight = Integer.parseInt(eingabe);

                if (height == eingabeHeight) {
                    Toast.makeText(ActivityTwo_Geradeaus.this, "Das ist korrekt", Toast.LENGTH_LONG).show();
                    isHeightCorrect = true;
                    // Start the next Activity
                } else {
                    Toast.makeText(ActivityTwo_Geradeaus.this, "Das ist falsch", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });

        mediaPlayer = MediaPlayer.create(this, R.raw.sound_rollenspiel);


    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                tvCounter.setText(Integer.toString(msg.what));
                Log.i("Counter", "Receiving");
            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 10; i >= 0; i--) {
                    if (isHeightCorrect) {
                        threadCounter.interrupt();
                    }
                    handler.sendEmptyMessage(i);
                    try {
                        Thread.sleep(1000);
                        Log.i("Counter", "Working");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (!isHeightCorrect) {
                    finish();
                }

            }
        };
        threadCounter = new Thread(runnable);
        threadCounter.start();


    }
}
