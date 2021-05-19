package com.myapplicationdev.android.final_bucket_list;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
// DAO (Data Access Object) as it would manage local data for SQLite data source using objects
// DAO must always be an interface/abstract because when using room database  as only method names and required
// query operations are written

public interface MyImagesDAO {
    // Todo:  An interface is a completely "abstract class" that is used
    //  to group related methods with empty bodies

    // Todo: Create Method
    @Insert
    void Insert(MyImages myImages);

    // Todo: Delete Method
    @Delete
    void Delete(MyImages myImages);

    // Todo: Update Method
    @Update
    void Update(MyImages myImages);

    // Todo: Read Method
    @Query("SELECT * FROM bucket_list ORDER BY image_id ASC")
    LiveData<List<MyImages>> getAllImages();
}
