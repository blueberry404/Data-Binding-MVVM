package anum.databinding.login;

import android.text.TextUtils;

import java.lang.ref.WeakReference;

import anum.databinding.models.UserModel;
import anum.databinding.service.MockService;
import anum.databinding.service.ServiceCallback;

public class LoginViewModel {

    private WeakReference<LoginNavigator> navigator;

    public boolean isValidUsernameAndPassword(String username, String password) {

        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password))
            return false;

        return true;
    }

    public void validateUserFromServer(String username, String password) {
        new MockService().loginUser(username, password, new ServiceCallback() {
            @Override
            public void successExecution(Object response) {
                if(navigator.get() != null) {
                    navigator.get().navigateToHomeScreen((UserModel) response);
                }
            }
        });

    }

    public void setNavigator(LoginNavigator navigator) {
        this.navigator = new WeakReference(navigator);
    }
}
