package com.example.infs3605v1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.infs3605v1.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar loadingCircle;
    Intent intent;
    Timer timer;
    TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadingCircle = findViewById(R.id.loadingCircle);

        //loading screen
        intent = new Intent(getApplicationContext(), LoginActivity.class);

        timerTask = new LoadingTask();
        timer = new Timer();
        timer.schedule(timerTask, 3000);

    }

    class LoadingTask extends TimerTask {
        public void run() {
            finish();
            startActivity(intent);
        }
    }



}

