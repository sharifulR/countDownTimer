package com.example.timecountdown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button startBtn;
    TextView timeTV;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis=600000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn=findViewById(R.id.startBtn);
        timeTV=findViewById(R.id.timeCountTV);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTime();
            }
        });
    }

    private void startTime() {
        countDownTimer= new CountDownTimer(timeLeftInMillis, 1000) {

            public void onTick(long millisUntilFinished) {
                timeLeftInMillis=millisUntilFinished;
                updateCountDownTimer();
            }

            public void onFinish() {
                timeTV.setText("done!");
            }

        }.start();
    }

    private void updateCountDownTimer() {
        int minutes=(int) (timeLeftInMillis/1000)/60;
        int seconds=(int) (timeLeftInMillis/1000)%60;

        String timeFormatted= String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        timeTV.setText("seconds remaining: " +timeFormatted);
    }
}