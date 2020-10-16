package com.example.proiect;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;

public class BooksView extends AndroidViewModel {
    private String TAG=this.getClass().getSimpleName();

    public BooksView(Application application){super(application);}

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG,"Bookview");
    }
}
