package com.example.pw.rollenspiel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by PW on 15.01.17.
 */
public class ActivityTwo_Left extends AppCompatActivity {

    TextView tvClickLeft;
    TextView tvClickRight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_left);

        tvClickLeft = (TextView) findViewById(R.id.tvFragen);
        tvClickRight = (TextView) findViewById(R.id.tvnichtFragen);


        tvClickLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
            }
        });

    }
}
