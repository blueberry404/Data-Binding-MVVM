package anum.databinding.login;

import anum.databinding.models.User;

public interface LoginNavigator {

    void onLogin();
    void navigateToHomeScreen(User user);
}
