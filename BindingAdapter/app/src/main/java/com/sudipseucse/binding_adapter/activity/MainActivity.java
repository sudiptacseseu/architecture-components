package com.sudipseucse.binding_adapter.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.sudipseucse.binding_adapter.R;
import com.sudipseucse.binding_adapter.databinding.ActivityMainBinding;
import com.sudipseucse.binding_adapter.model.Post;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Post post = new Post(getResources().getString(R.string.image_description), getResources().getString(R.string.author),
                "https://picsum.photos/200");

        //Data object binding
        binding.setPost(post);
    }
}