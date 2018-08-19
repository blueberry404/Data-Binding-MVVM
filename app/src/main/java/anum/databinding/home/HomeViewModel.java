package anum.databinding.home;

import anum.databinding.models.UserModel;

public class HomeViewModel {

    UserModel user;

    public HomeViewModel(UserModel user) {
        this.user = user;
    }

    public String getName() {
        return String.format("%s %s", user.getFirstname(), user.getLastname());
    }

    public String getEmail() {
        return user.getEmail();
    }

    public String getTenure() {
        return String.format("%d years",user.getTenure());
    }
}
