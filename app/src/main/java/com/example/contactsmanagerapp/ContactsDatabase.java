package com.example.contactsmanagerapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ContactsModel.class}, version = 1)
public abstract class ContactsDatabase extends RoomDatabase {
    public abstract ContactsDao getContactsDao();

    // singleton
    private static ContactsDatabase dbInstance;

    public static synchronized ContactsDatabase getInstance(Context context){
        if (dbInstance == null){
            dbInstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ContactsDatabase.class,
                    "contacts_db"
            ).fallbackToDestructiveMigration().build();
        }
        return dbInstance;
    }
}
