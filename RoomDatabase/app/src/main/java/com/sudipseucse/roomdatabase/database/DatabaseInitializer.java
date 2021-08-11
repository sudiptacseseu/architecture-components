package com.sudipseucse.roomdatabase.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.sudipseucse.roomdatabase.dao.ContactDao;
import com.sudipseucse.roomdatabase.model.Contact;
import com.sudipseucse.roomdatabase.util.Converter;

@Database(entities = {Contact.class}, version = 1, exportSchema = false)
@TypeConverters(Converter.class)
public abstract class DatabaseInitializer extends RoomDatabase {

    public abstract ContactDao ContactDao();

    private static DatabaseInitializer INSTANCE;

    // For manual migration
    /*static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE contact "
                    + " ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)");
        }
    };**/

    public static DatabaseInitializer getDatabase(Context context){

        //Singleton implementation
        if(INSTANCE == null){

            //Prevents multiple database initializations
            synchronized (DatabaseInitializer.class){

                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        DatabaseInitializer.class,"contact_db")

                        //Wipes and rebuilds instead of migrating if no Migration object.
                        //.fallbackToDestructiveMigration()

                        //If manual migration needed
                        //.addMigrations(MIGRATION_1_2)
                        .build();
            }

        }

        return INSTANCE;
    }
}
