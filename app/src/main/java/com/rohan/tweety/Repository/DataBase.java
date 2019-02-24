package com.rohan.tweety.Repository;

import android.content.Context;

import com.rohan.tweety.Repository.Entities.Hashtags;
import com.rohan.tweety.Repository.Entities.Users;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Hashtags.class,Users.class},version = 1)
public abstract class DataBase extends RoomDatabase {

    public abstract com.rohan.tweety.Repository.DAOs.HashTagsDao hDao();
    public abstract com.rohan.tweety.Repository.DAOs.UsersTrackedDao uDao();

    public static volatile DataBase INSTANCE;

    public static DataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DataBase.class, "Database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
