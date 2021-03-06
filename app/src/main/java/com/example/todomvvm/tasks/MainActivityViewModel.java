package com.example.todomvvm.tasks;

import android.app.Application;
import android.view.View;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.todomvvm.database.AppDatabase;
import com.example.todomvvm.database.Repository;
import com.example.todomvvm.database.TaskEntry;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    Repository repository;

   private  LiveData<List<TaskEntry>> tasks;



    public  MainActivityViewModel(Application application){
        super(application);
        AppDatabase database = AppDatabase.getInstance(application);
        repository = new Repository(database);

    }

    public LiveData<List<TaskEntry>> getTasks(int user_id){

        return repository.getTasks(user_id);

    }

    public void deleteTask(TaskEntry task){
        repository.deleteTask(task);
    }

    public void deleteAllNotes(){
        repository.deleteAllNotes();
    }

}
