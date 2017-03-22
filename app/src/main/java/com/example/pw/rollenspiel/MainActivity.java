package com.example.pw.rollenspiel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvClickOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find TextView in Layout and connect it to variable tvClickOne
        tvClickOne = (TextView)findViewById(R.id.tvClickOne);

        // Set behaviour for TextView when clicked
        tvClickOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_LONG).show();
                //Log.i("onCreate", "Click");
                Intent intentOne = new Intent(MainActivity.this, ActivityOne.class);
                startActivity(intentOne);
            }
        });


    }
}
