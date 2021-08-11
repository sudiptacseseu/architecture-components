package com.sudipseucse.roomdatabase.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sudipseucse.roomdatabase.R;
import com.sudipseucse.roomdatabase.database.DatabaseInitializer;
import com.sudipseucse.roomdatabase.model.Contact;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseInitializer databaseInitializer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Without singleton and allow main thread queries for testing purpose only
        // databaseInitializer= Room.databaseBuilder(this, DatabaseInitializer.class,"contact_db").allowMainThreadQueries().build();

        databaseInitializer = DatabaseInitializer.getDatabase(MainActivity.this);

        // Async task to run on main thread
        AsyncTask.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        databaseInitializer.ContactDao().insertContact(new Contact(0,"John", "01611111111",new Date()));
                    }
                }
        );
    }

    public void getData(View view) {
        databaseInitializer.ContactDao().getContacts().observe(MainActivity.this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> contacts) {
                Log.d("ContactList",contacts.toString());
            }
        });
    }
}