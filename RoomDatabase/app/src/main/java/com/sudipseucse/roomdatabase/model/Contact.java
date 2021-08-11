package com.sudipseucse.roomdatabase.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "contact")
public class Contact {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String phone;
    public Date createdDate;

    public Contact(int id, String name, String phone, Date createdDate) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.createdDate = createdDate;
    }
}
