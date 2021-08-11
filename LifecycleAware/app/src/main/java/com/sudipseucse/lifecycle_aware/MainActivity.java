package com.sudipseucse.lifecycle_aware;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLifecycle().addObserver(new Observer());
        Log.d("Main", "Activity-onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Main", "Activity-onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Main", "Activity-onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Main", "Activity-onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Main", "Activity-onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Main", "Activity-onDestroy");
    }
}