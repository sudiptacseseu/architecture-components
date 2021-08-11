package com.sudipseucse.view_model;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    int counter = 0;

    public void increment() {
        counter++;
    }
}
