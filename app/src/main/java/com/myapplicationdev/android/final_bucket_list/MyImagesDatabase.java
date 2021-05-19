package com.myapplicationdev.android.final_bucket_list;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = MyImages.class, version = 1)
// Abstract class: is a restricted class that cannot be used to create objects
// (to access it, it must be inherited from another class).
public abstract class MyImagesDatabase extends RoomDatabase {

    static MyImagesDatabase instance;

    abstract MyImagesDAO myImagesDAO();

    // Abstract method: can only be used in an abstract class, and it does not have a body.
    // The body is provided by the subclass (inherited from).
    public static synchronized MyImagesDatabase getInstance(Context context) {

        // if no database has been created
        if (instance == null) {

            // necessary databse will be created if theres no database
            instance = Room.databaseBuilder(context.getApplicationContext()
                    , MyImagesDatabase.class, "my_images_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }

}
