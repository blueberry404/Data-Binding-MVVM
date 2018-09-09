package anum.databinding.login;

import java.lang.ref.WeakReference;

import anum.databinding.data.AppRepository;
import anum.databinding.models.User;
import anum.databinding.service.ServiceCallback;
import anum.databinding.utils.CommonUtils;

public class LoginViewModel {

    private WeakReference<LoginNavigator> navigator;
    private AppRepository repository;

    public LoginViewModel(AppRepository repository, LoginNavigator navigator) {
        this.repository = repository;
        this.navigator = new WeakReference(navigator);
    }

    public boolean isValidUsernameAndPassword(String username, String password) {

        if(CommonUtils.isNullOrEmptyString(username) ||
                CommonUtils.isNullOrEmptyString(password))
            return false;

        return true;
    }

    public void validateUserFromServer(String username, String password) {
        repository.loginUser(username, password, new ServiceCallback() {
            @Override
            public void successExecution(Object response) {
                if(navigator.get() != null) {
                    navigator.get().navigateToHomeScreen((User) response);
                }
            }
        });

    }
}
