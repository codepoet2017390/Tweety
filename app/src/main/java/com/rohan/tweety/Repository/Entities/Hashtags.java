package com.rohan.tweety.Repository.Entities;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Searched_Hashtags")
public class Hashtags {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "Hashtags Searched")
    private String HashTag;

    @ColumnInfo(name = "frequency")
    private int count=0;


    public Hashtags(@NonNull String hashTag,int count) {
        HashTag = hashTag;
        this.count=count;
    }

    @NonNull
    public String getHashTag() {
        return HashTag;
    }

    public int getCount() {
        return count;
    }
}
