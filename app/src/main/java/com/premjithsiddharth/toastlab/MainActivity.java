package com.premjithsiddharth.toastlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView topLeft;
    TextView topRight;
    TextView bottomLeft;
    TextView bottomRight;
    Toast toast;
    int[] count;
    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topLeft = findViewById(R.id.top_left);
        topRight = findViewById(R.id.top_right);
        bottomLeft = findViewById(R.id.bottom_left);
        bottomRight = findViewById(R.id.bottom_right);
        count = {0, 0, 0, 0};
        Listener x = new Listener();
        bottomLeft.setOnClickListener(x);
        bottomRight.setOnClickListener(x);
        topLeft.setOnClickListener(x);
        topRight.setOnClickListener(x);
        sharedPref = getSharedPreferences("Settings", Context.MODE_PRIVATE);
    }
    public class Listener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            TextView text = (TextView)v;

        }
    }
}
