package com.hjs.himanishah.uwatch.Model;

/**
 * Created by dhruvinpatel on 10/15/17.
 */
import android.os.Parcel;
import android.os.Parcelable;

public class Movies implements Parcelable {
    public String display_name;
    public float rating;
    public Double popularity;
    public String released_date;
    public String overview;
    public String poster_url;
    public int id;

    public Movies(){

    }

    protected Movies(Parcel in) {
        display_name = in.readString();
        rating = in.readFloat();
        popularity = in.readByte() == 0x00 ? null : in.readDouble();
        released_date = in.readString();
        overview = in.readString();
        poster_url = in.readString();
        id = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(display_name);
        dest.writeFloat(rating);
        if (popularity == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(popularity);
        }
        dest.writeString(released_date);
        dest.writeString(overview);
        dest.writeString(poster_url);
        dest.writeInt(id);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Movies> CREATOR = new Parcelable.Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };
}