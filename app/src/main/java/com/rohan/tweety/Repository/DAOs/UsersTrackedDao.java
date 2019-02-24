package com.rohan.tweety.Repository.DAOs;

import com.rohan.tweety.Repository.Entities.Users;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UsersTrackedDao {


    @Insert
    void insertUser(Users user);

    @Delete
    void DeleteUser(Users user);

    @Query("SELECT * FROM UsersTracked ORDER BY serial_number ASC")
    LiveData<List<Users>> displayAll();

}
