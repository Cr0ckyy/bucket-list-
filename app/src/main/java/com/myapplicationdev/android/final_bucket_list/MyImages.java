package com.myapplicationdev.android.final_bucket_list;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "bucket_list")
// Todo: crating the the database table and its data
public class MyImages {

    @PrimaryKey(autoGenerate = true)
    public int image_id;
    public String image_title;
    public String image_description;
    public float image_rating;
    public byte[] image;

    public MyImages(int image_id, String image_title, String image_description, float image_rating, byte[] image) {
        this.image_id = image_id;
        this.image_title = image_title;
        this.image_description = image_description;
        this.image_rating = image_rating;
        this.image = image;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getImage_title() {
        return image_title;
    }

    public void setImage_title(String image_title) {
        this.image_title = image_title;
    }

    public String getImage_description() {
        return image_description;
    }

    public void setImage_description(String image_description) {
        this.image_description = image_description;
    }

    public float getImage_rating() {
        return image_rating;
    }

    public void setImage_rating(float image_rating) {
        this.image_rating = image_rating;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
