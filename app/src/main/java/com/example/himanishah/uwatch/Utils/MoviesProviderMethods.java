package com.example.himanishah.uwatch.Utils;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;

import com.example.himanishah.uwatch.Model.MoviesData;

import java.util.ArrayList;

import static com.example.himanishah.uwatch.Model.ResponseKeys.COVER_IMAGE;
import static com.example.himanishah.uwatch.Model.ResponseKeys.DURATION;
import static com.example.himanishah.uwatch.Model.ResponseKeys.GENRE_NAME;
import static com.example.himanishah.uwatch.Model.ResponseKeys.ID;
import static com.example.himanishah.uwatch.Model.ResponseKeys.IMAGE;
import static com.example.himanishah.uwatch.Model.ResponseKeys.LANGUAGE;
import static com.example.himanishah.uwatch.Model.ResponseKeys.OVERVIEW;
import static com.example.himanishah.uwatch.Model.ResponseKeys.POPULARITY;
import static com.example.himanishah.uwatch.Model.ResponseKeys.RATING;
import static com.example.himanishah.uwatch.Model.ResponseKeys.RELEASE_DATE;
import static com.example.himanishah.uwatch.Model.ResponseKeys.STATUS;
import static com.example.himanishah.uwatch.Model.ResponseKeys.TAGLINE;
import static com.example.himanishah.uwatch.Model.ResponseKeys.TITLE;

/**
 * Created by dhruvinpatel on 10/15/17.
 */

public class MoviesProviderMethods {

    public static boolean isMovieInDatabase(Activity activity, int id){

        ArrayList<MoviesData> list = new ArrayList<>(MoviesProviderMethods.getMovieList(activity));
        for(MoviesData listItem : list){
            if(listItem.getId() == id){
                return true;
            }
        }
        return false;
    }

    public static ArrayList<MoviesData> getMovieList(Activity activity){

        ArrayList<MoviesData> movieList = new ArrayList<>();
        Uri contentUri = MoviesProvider.BASE_CONTENT_URI;
        Cursor c = activity.getContentResolver().query(contentUri, null, null, null, null);

        if(c.moveToFirst()){
            do{

                MoviesData movie = new MoviesData(
                        c.getInt(c.getColumnIndex(ID)),
                        c.getString(c.getColumnIndex(IMAGE)),
                        c.getString(c.getColumnIndex(TITLE)),
                        c.getString(c.getColumnIndex(GENRE_NAME)),
                        c.getFloat(c.getColumnIndex(POPULARITY)),
                        c.getFloat(c.getColumnIndex(RATING))
                );
                movieList.add(movie);
            }while(c.moveToNext());
        }
        c.close();
        return movieList;
    }

    public static MoviesData getMovieFromDatabase(Activity activity, String id){

        MoviesData movieData = null;
        Uri contentUri = MoviesProvider.BASE_CONTENT_URI;
        Cursor c = activity.getContentResolver().query(contentUri, null, null, null, null);

        if(c.moveToFirst()){
            do{
                if(id.equals(c.getString(c.getColumnIndex(ID)))){
                    movieData = new MoviesData(
                            Integer.valueOf(c.getString(c.getColumnIndex(ID))),
                            c.getString(c.getColumnIndex(TITLE)),
                            c.getString(c.getColumnIndex(TAGLINE)),
                            c.getString(c.getColumnIndex(STATUS)),
                            c.getString(c.getColumnIndex(RELEASE_DATE)),
                            c.getString(c.getColumnIndex(GENRE_NAME)),
                            c.getString(c.getColumnIndex(IMAGE)),
                            c.getString(c.getColumnIndex(COVER_IMAGE)),
                            c.getInt(c.getColumnIndex(DURATION)),
                            c.getFloat(c.getColumnIndex(POPULARITY)),
                            c.getString(c.getColumnIndex(OVERVIEW)),
                            c.getFloat(c.getColumnIndex(RATING)),
                            c.getString(c.getColumnIndex(LANGUAGE))
                    );
                    break;
                }
            }while(c.moveToNext());
        }
        c.close();
        return movieData;
    }
}

