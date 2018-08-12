package anum.databinding.login;

import android.text.TextUtils;

import java.lang.ref.WeakReference;

public class LoginViewModel {

    private WeakReference<LoginNavigator> navigator;

    public boolean isValidUsernameAndPassword(String username, String password) {

        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password))
            return false;

        return true;
    }

    public void validateUserFromServer() {
        //You can do this after async call
        if(navigator.get() != null) {
            navigator.get().navigateToHomeScreen();
        }
    }

    public void setNavigator(LoginNavigator navigator) {
        this.navigator = new WeakReference(navigator);
    }
}
