package com.sudipseucse.view_model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewCount;
    MainViewModel mainViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        textViewCount = findViewById(R.id.textviewDisplayCount);
        showCounterValue();
    }

    public void showCounterValue() {
        textViewCount.setText(String.valueOf(mainViewModel.counter));
    }

    public void increment(View view) {
        mainViewModel.increment();
        showCounterValue();
    }
}