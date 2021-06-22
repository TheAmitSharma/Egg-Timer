package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
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
        change_timer_seekBar.setProgress(30);

        change_timer_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {

                updateTimerFunction(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void begin_timer(View view) {
        CountDownTimer countDownTimer = new CountDownTimer(change_timer_seekBar.getProgress()*1000 + 100,1000) {
            @Override
            public void onTick(long l) {
                updateTimerFunction((int) l /1000);
            }

            @Override
            public void onFinish() {
                Log.i("Countdown","Finished");
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.alarm_noam);
                mediaPlayer.start();
            }
        }.start();
    }
    public void updateTimerFunction(int secondsLeft){
        int minutes = secondsLeft/60;
        int seconds = secondsLeft - (minutes * 60);

        String secondsString = Integer.toString(seconds);
        if (seconds <=9){
            secondsString = "0" + secondsString;
        }
        timer_textView.setText(Integer.toString(minutes) + ":" + secondsString);
    }
}