package com.sudipseucse.live_data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<String> factsLiveDataObject = new MutableLiveData<>("Learning LiveData is a fact!");


    LiveData<String> getFactsLiveData(){
        return factsLiveDataObject;
    }

    public void updateValue() {
        factsLiveDataObject.setValue("Learning done and this is another fact!");
    }
}
