package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar change_timer_seekBar;
    Button begin_button;
    TextView timer_textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        change_timer_seekBar = findViewById(R.id.seekBar);
        begin_button = findViewById(R.id.begin_button);
        timer_textView = findViewById(R.id.timer);

        change_timer_seekBar.setMax(600);
        change_timer_seekBar.setProgress(10);

        change_timer_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                int minutes = i/60;
                int seconds = i - (minutes * 60);

                String secondsString = Integer.toString(seconds);
                if (secondsString.equals("0")){
                    secondsString = "00";
                }

                timer_textView.setText(Integer.toString(minutes) + ":" + secondsString);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}