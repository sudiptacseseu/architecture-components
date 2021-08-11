package com.sudipseucse.roomdatabase.util;

import androidx.room.TypeConverter;

import java.util.Date;

public class Converter {

    @TypeConverter
    public Long fromDateToLong(Date value){
        return value.getTime();
    }

    @TypeConverter
    public Date fromLongToDate(Long value){
        return new Date(value);
    }
}
