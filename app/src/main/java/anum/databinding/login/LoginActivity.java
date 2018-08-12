package anum.databinding.login;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import anum.databinding.R;
import anum.databinding.databinding.ActivityLoginBinding;
import anum.databinding.utils.Utils;

public class LoginActivity extends AppCompatActivity implements LoginHandler, LoginNavigator {

    ActivityLoginBinding loginBinding;
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginViewModel = new LoginViewModel();
        loginViewModel.setNavigator(this);
        loginBinding.setLoginModel(loginViewModel);
        loginBinding.setCallback(this);
    }

    @Override
    public void onLogin() {
        if(!loginViewModel.isValidUsernameAndPassword(
                loginBinding.editUsername.getText().toString(),
                loginBinding.editPassword.getText().toString()
        )) {
            Utils.showAlertDialog(this, "Please enter valid username or password");
            return;
        }
        //TODO: In activity or viewmodel?
        loginViewModel.validateUserFromServer();
    }

    @Override
    public void navigateToHomeScreen() {

    }
}
