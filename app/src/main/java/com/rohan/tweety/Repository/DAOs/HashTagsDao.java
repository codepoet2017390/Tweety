package com.rohan.tweety.Repository.DAOs;

import com.rohan.tweety.Repository.Entities.Hashtags;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface HashTagsDao {

    @Insert
    void insertHashtag(Hashtags hashtag);

    @Query("UPDATE Searched_Hashtags" +
            " SET frequency= frequency+1" +
            " WHERE `Hashtags Searched`= :hashtags")
    void updateHashTagFrequency(Hashtags hashtags);


    @Query("SELECT * FROM Searched_Hashtags ORDER BY frequency DESC")
    LiveData<List<Hashtags>> displayAll();

}
