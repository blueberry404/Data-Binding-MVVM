package anum.databinding.login;

import android.text.TextUtils;

public class LoginViewModel {

    private LoginNavigator navigator;

    public boolean isValidUsernameAndPassword(String username, String password) {

        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password))
            return false;

        return true;
    }

    public void validateUserFromServer() {
        //You can do this after async call
        if(navigator != null) {
            navigator.navigateToHomeScreen();
        }
    }

    public void setNavigator(LoginNavigator navigator) {
        this.navigator = navigator;
    }
}
