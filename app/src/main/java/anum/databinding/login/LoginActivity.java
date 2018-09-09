package anum.databinding.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import anum.databinding.Base.BaseActivity;
import anum.databinding.data.AppRepository;
import anum.databinding.home.HomeActivity;
import anum.databinding.R;
import anum.databinding.databinding.ActivityLoginBinding;
import anum.databinding.models.User;
import anum.databinding.service.AppRepositoryRemoteImpl;
import anum.databinding.utils.CommonUtils;

public class LoginActivity extends BaseActivity implements LoginHandler, LoginNavigator {

    ActivityLoginBinding loginBinding;
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginViewModel = new LoginViewModel(getRepository(), this);
        loginBinding.setCallback(this);
    }

    @Override
    public void onLogin() {
        hideKeyboard();
        String username = loginBinding.editUsername.getText().toString();
        String password = loginBinding.editPassword.getText().toString();
        if(!loginViewModel.isValidUsernameAndPassword(username, password)) {
            CommonUtils.showAlertDialog(this, "Please enter valid username or password");
            return;
        }
        loginViewModel.validateUserFromServer(username, password);
    }

    @Override
    public void navigateToHomeScreen(User user) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
        finish();
    }

    @Override
    protected AppRepository getRepository() {
        return new AppRepositoryRemoteImpl();
    }
}
