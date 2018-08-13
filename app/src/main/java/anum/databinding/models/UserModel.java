package anum.databinding.models;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {

    String firstname;
    String lastname;
    String email;
    int tenure;

    public UserModel(String firstname, String lastname, String email, int tenure) {
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

    public String getFormattedTenure() {
        return String.format("%d years",tenure);
    }

    protected UserModel(Parcel in) {
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
    public static final Parcelable.Creator<UserModel> CREATOR = new Parcelable.Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };
}