package com.rohan.tweety.Repository;

import android.app.Application;
import android.os.AsyncTask;

import com.rohan.tweety.Repository.DAOs.HashTagsDao;
import com.rohan.tweety.Repository.DAOs.UsersTrackedDao;
import com.rohan.tweety.Repository.Entities.Hashtags;
import com.rohan.tweety.Repository.Entities.Users;

import java.util.List;

import androidx.lifecycle.LiveData;

public class DataRepository {

    static HashTagsDao hdao;

    static UsersTrackedDao udao;

    LiveData<List<Users>> UserList;
    LiveData<List<Hashtags>> HashList;
    public DataRepository(Application application)
    {
        DataBase db=DataBase.getDatabase(application);
        hdao=db.hDao();
        udao=db.uDao();
    }

    public LiveData<List<Users>> getUsers()
    {
        UserList=udao.displayAll();
        return UserList;
    }

    public LiveData<List<Hashtags>> getHashTags()
    {
        HashList=hdao.displayAll();
        return HashList;
    }

    public void insertUser(Users... user)
    {
        new InsertUserTask().execute(user);
    }

    private static class InsertUserTask extends AsyncTask<Users,Void,Void>
    {
        @Override
        protected Void doInBackground(Users... users) {
            udao.insertUser(users[0]);
            return null;
        }
    }

    public void insertHashTag(Hashtags... hashtags)
    {
        new InsertHashTagTask().execute(hashtags);
    }

    public void UpdateHashTag(Hashtags hashtag)
    {
      new UpdateTask().execute(hashtag);
    }

    private static class UpdateTask extends AsyncTask<Hashtags,Void,Void>
    {
        @Override
        protected Void doInBackground(Hashtags... hashtags) {
            hdao.updateHashTagFrequency(hashtags[0]);
            return null;
        }
    }

    private static class InsertHashTagTask extends AsyncTask<Hashtags,Void,Void>
    {
        @Override
        protected Void doInBackground(Hashtags... users) {
            hdao.insertHashtag(users[0]);
            return null;
        }
    }


}
