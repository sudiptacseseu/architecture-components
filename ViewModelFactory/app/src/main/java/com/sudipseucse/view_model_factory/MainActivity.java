package com.sudipseucse.view_model_factory;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    TextView textViewCount;
    MainViewModel mainViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this, new MainViewModelFactory(10)).get(MainViewModel.class);
        textViewCount = findViewById(R.id.textviewDisplayCount);
        showCounterValue();
    }

    public void increment(View view) {
        mainViewModel.increment();
        showCounterValue();
    }

    public void showCounterValue() {
        textViewCount.setText(String.valueOf(mainViewModel.counter));
    }

}