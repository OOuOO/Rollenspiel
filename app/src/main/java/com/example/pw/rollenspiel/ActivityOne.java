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
public class ActivityOne extends AppCompatActivity {

    TextView tvClickLeft;   //  teeeeeeest
    TextView tvClickRight;
    TextView tvClickGeradeaus;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        tvClickLeft = (TextView)findViewById(R.id.tvLeft);
        tvClickRight = (TextView)findViewById(R.id.tvRight);
        tvClickGeradeaus = (TextView) findViewById(R.id.tvMiddle);

        tvClickLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTwo_Left = new Intent(ActivityOne.this, ActivityTwo_Left.class);
                startActivity(intentTwo_Left);
            }
        });

        tvClickRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTwo_Right = new Intent(ActivityOne.this, ActivityTwo_Right.class);
                startActivity(intentTwo_Right);
            }
        });


        tvClickGeradeaus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTwo_Geradeaus = new Intent(ActivityOne.this, ActivityTwo_Geradeaus.class);
                startActivity(intentTwo_Geradeaus);
            }
        });
    }
}
