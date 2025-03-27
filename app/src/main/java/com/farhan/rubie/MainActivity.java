package com.farhan.rubie;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends Activity {
private long startTime = 0L;
private Handler timerHandler = new Handler();
private Runnable timerRunnable;
private TextView timerTextView;
private int minutes = 0;
private int seconds = 0;
private int milisecs = 0;
private int remainingSeconds = 0;
Boolean isRunning = false;
public long totalmilisecs = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerTextView = findViewById(R.id.timer);

        timerRunnable = new Runnable(){
            @Override
            public void run(){
                if(isRunning){

                    totalmilisecs += 10;
                    minutes = (int) totalmilisecs/60000;
                    remainingSeconds = (int) totalmilisecs%60000;
                    seconds = remainingSeconds/1000;
                    milisecs = (remainingSeconds%1000)/10;
                    String timeFormatted = String.format("%02d:%02d:%02d",minutes,seconds,milisecs);
                    timerTextView.setText(timeFormatted);
                }
                timerTextView.postDelayed(this, 10);
                }
            };

        Button myButton = findViewById(R.id.button_start);
        myButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "@farhann_6389!!!", Toast.LENGTH_SHORT).show();
                return true; // Return true to indicate the event is handled
            }
        });

    }




public void onClickStart(View view) {
    TextView buttontext = findViewById(R.id.button_start);
    String buttontextstr = buttontext.getText().toString();

    if(buttontextstr.equals("START")){
        buttontext.setText("STOP");
        isRunning = true;
        totalmilisecs = 0L;
        timerHandler.post(timerRunnable);
    }
    else if(buttontextstr.equals("STOP")){
        buttontext.setText("RESTART");
        isRunning = false;
//        timerHandler.removeCallbacks(timerRunnable);
    }
    else{
        buttontext.setText("START");
        totalmilisecs = 0L;
        timerTextView.setText("00:00");
        isRunning = false;
    }
}}

