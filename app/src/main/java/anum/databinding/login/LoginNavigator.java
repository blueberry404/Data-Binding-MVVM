package anum.databinding.login;

import anum.databinding.models.UserModel;

public interface LoginNavigator {

    void onLogin();
    void navigateToHomeScreen(UserModel userModel);
}
