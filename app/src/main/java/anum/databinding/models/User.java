package anum.databinding.models;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    String firstname;
    String lastname;
    String email;
    int tenure;

    public User(String firstname, String lastname, String email, int tenure) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.tenure = tenure;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public int getTenure() {
        return tenure;
    }

    protected User(Parcel in) {
        firstname = in.readString();
        lastname = in.readString();
        email = in.readString();
        tenure = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstname);
        dest.writeString(lastname);
        dest.writeString(email);
        dest.writeInt(tenure);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}