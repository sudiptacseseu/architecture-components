package com.sudipseucse.data_binding.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import com.sudipseucse.data_binding.R;
import com.sudipseucse.data_binding.databinding.ActivityMainBinding;
import com.sudipseucse.data_binding.model.Quote;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //Only view binding
        /*binding.textViewAuthor.setText(R.string.author);
          binding.textViewQuote.setText(R.string.quote);**/

        Quote quote = new Quote(getResources().getString(R.string.quote), getResources().getString(R.string.author));

        //Data object binding
        binding.setQuote(quote);
    }
}