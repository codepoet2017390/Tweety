package com.rohan.tweety.Repository.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "UsersTracked")
public class Users {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int serial_number;

    @NonNull
    @ColumnInfo
    private String Username;

    public Users(int serial_number, @NonNull String username) {
        this.serial_number = serial_number;
        Username = username;
    }

    @NonNull
    public String getUsername() {
        return Username;
    }

    public int getSerial_number() {
        return serial_number;
    }
}
