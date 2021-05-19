package com.myapplicationdev.android.final_bucket_list;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

// Todo: To do: create a temporary storage repository for the app's data, as well as relevant API methods for the UI to communicate with.
public class MyImagesRepository {

    // TODO: create relevant objects
    MyImagesDAO myImagesDAO;
    // a series from the model class that will be under the supervision of the LiveData
    LiveData<List<MyImages>> imagesList;

    public MyImagesRepository(Application application) {
        MyImagesDatabase database = MyImagesDatabase.getInstance(application);
        myImagesDAO = database.myImagesDAO();
        imagesList = myImagesDAO.getAllImages();
    }


    // TODO: create Method
    public void insert(MyImages myImages) {

      /* AsyncTask prevents the application from performing important operations such as writing files,
        reading files, and downloading from the internet while it is running,
                and then allows it to perform all of these functions synchronously in the background*/

        // To prevent the application from running slowly as a result of its ongoing operations,
        // Android OS will simply run an application in one thread, which is the main thread.

        // This main thread is used by all of the application's components,
        // including the activities and the provider.
        new InsertImageAsyncTask(myImagesDAO).execute(myImages);
    }

    // TODO: read Method
    public LiveData<List<MyImages>> getAllImages() {
        return imagesList;
    }

    // TODO: update Method
    public void update(MyImages myImages) {
        new UpdateImageAsyncTask(myImagesDAO).execute(myImages);
    }

    // TODO: delete Method
    public void delete(MyImages myImages) {
        new DeleteImageAsyncTask(myImagesDAO).execute(myImages);
    }

    public static class InsertImageAsyncTask extends AsyncTask<MyImages, Void, Void> {

        MyImagesDAO imagesDAO;

        public InsertImageAsyncTask(MyImagesDAO imagesDAO) {
            this.imagesDAO = imagesDAO;
        }

        @Override
        protected Void doInBackground(MyImages... myImages) {

            imagesDAO.Insert(myImages[0]);
            return null;
        }
    }

    public static class DeleteImageAsyncTask extends AsyncTask<MyImages, Void, Void> {

        MyImagesDAO imagesDAO;

        public DeleteImageAsyncTask(MyImagesDAO imagesDAO) {
            this.imagesDAO = imagesDAO;
        }

        @Override
        protected Void doInBackground(MyImages... myImages) {

            imagesDAO.Delete(myImages[0]);
            return null;
        }
    }

    public static class UpdateImageAsyncTask extends AsyncTask<MyImages, Void, Void> {

        MyImagesDAO imagesDAO;

        public UpdateImageAsyncTask(MyImagesDAO imagesDAO) {
            this.imagesDAO = imagesDAO;
        }

        @Override
        protected Void doInBackground(MyImages... myImages) {

            imagesDAO.Update(myImages[0]);
            return null;
        }
    }

}
