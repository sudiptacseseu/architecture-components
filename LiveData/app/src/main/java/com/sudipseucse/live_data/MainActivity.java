package com.sudipseucse.live_data;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    TextView textViewCount;
    MainViewModel mainViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        textViewCount = findViewById(R.id.textviewDisplayCount);
        mainViewModel.getFactsLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textViewCount.setText(s);
            }
        });
    }

    public void updateValue(View view) {
        mainViewModel.updateValue();
    }
}