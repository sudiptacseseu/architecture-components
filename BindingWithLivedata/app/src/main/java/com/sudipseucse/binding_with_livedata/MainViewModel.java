package com.sudipseucse.binding_with_livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MutableLiveData<String> factsLiveDataObject = new MutableLiveData<>("Learning LiveData is a fact!");

    public void updateQuote() {
        factsLiveDataObject.setValue("Learning done and this is another fact!");
    }
}
