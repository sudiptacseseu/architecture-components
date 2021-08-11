package com.sudipseucse.view_model_factory;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    int counter;

    public MainViewModel(int count) {
        this.counter = count;
    }

    public void increment() {
        counter++;
    }
}
