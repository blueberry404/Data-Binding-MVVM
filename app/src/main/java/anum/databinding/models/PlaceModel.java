package anum.databinding.models;

import android.os.Parcel;
import android.os.Parcelable;

public class PlaceModel implements Parcelable {
    String name;
    String url;
    String details;

    public PlaceModel(String name, String url, String details) {
        this.name = name;
        this.url = url;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getDetails() {
        return details;
    }

    protected PlaceModel(Parcel in) {
        name = in.readString();
        url = in.readString();
        details = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(url);
        dest.writeString(details);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<PlaceModel> CREATOR = new Parcelable.Creator<PlaceModel>() {
        @Override
        public PlaceModel createFromParcel(Parcel in) {
            return new PlaceModel(in);
        }

        @Override
        public PlaceModel[] newArray(int size) {
            return new PlaceModel[size];
        }
    };
}