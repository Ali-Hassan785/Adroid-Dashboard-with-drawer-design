package com.example.androisdashboardwithrecylerview.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.androisdashboardwithrecylerview.R;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress);
        progressBar.setProgress(0);
        textView = findViewById(R.id.title);
        textView.setText(R.string.app_name);
        new Thread(new Runnable() {
            public void run() {
                doWork();
                startApp();
                finish();
            }
        }).start();

    }

    private void startApp() {
        Intent intent = new Intent(MainActivity.this, DashBoardActivity.class);
        startActivity(intent);
    }

    private void doWork() {
        for (int progress = 0; progress < 100; progress += 10) {
            try {
                Thread.sleep(500);
                progressBar.setProgress(progress);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

    }
}

