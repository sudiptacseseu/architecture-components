package com.sudipseucse.lifecycle_aware;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class Observer implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected void onCreate(){
        Log.d("Main", "Observer-onCreate");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void onStart(){
        Log.d("Main", "Observer-onStart");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    protected void onPause(){
        Log.d("Main", "Observer-onPause");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected void onResume(){
        Log.d("Main", "Observer-onResume");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected void onStop(){
        Log.d("Main", "Observer-onStop");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void onDestroy(){
        Log.d("Main", "Observer-onDestroy");

    }
}
