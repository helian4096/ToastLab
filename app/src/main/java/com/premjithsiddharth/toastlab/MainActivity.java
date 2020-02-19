package com.premjithsiddharth.toastlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView topLeft;
    TextView topRight;
    TextView bottomLeft;
    TextView bottomRight;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    Context context;
    CharSequence toastMessage;
    int duration;
    SeekBar seekbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPref = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        topLeft = findViewById(R.id.top_left);
        topRight = findViewById(R.id.top_right);
        bottomLeft = findViewById(R.id.bottom_left);
        bottomRight = findViewById(R.id.bottom_right);
        seekbar = findViewById(R.id.font_changer);
        Listener x = new Listener();
        bottomLeft.setOnClickListener(x);
        bottomRight.setOnClickListener(x);
        topLeft.setOnClickListener(x);
        topRight.setOnClickListener(x);
        editor.putInt((String)(topLeft.getText()), 0);
        editor.putInt((String)(topRight.getText()), 0);
        editor.putInt((String)(bottomLeft.getText()), 0);
        editor.putInt((String)(bottomRight.getText()), 0);
        editor.apply();
        context = getApplicationContext();
        toastMessage = "Hello, toast failed!";
        duration = Toast.LENGTH_SHORT;
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    int min = 15;
                    bottomLeft.setTextSize(min + progress/2);
                    bottomRight.setTextSize(min + progress/2);
                    topLeft.setTextSize(min + progress/2);
                    topRight.setTextSize(min + progress/2);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
    }
    public class Listener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            TextView text = (TextView)v;
            int x = sharedPref.getInt((String)(text.getText()), -1);
            x++;
            editor.putInt((String)(text.getText()), x);
            editor.apply();
            toastMessage = (CharSequence)(text.getText() + ": " + x);
            Toast.makeText(context, toastMessage, duration).show();
        }
    }
}
