package anum.databinding.home;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import anum.databinding.R;
import anum.databinding.databinding.ActivityHomeBinding;
import anum.databinding.models.UserModel;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding homeBinding;
    HomeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        populateUserInitials();
    }

    void populateUserInitials() {
        if(getIntent() != null) {
            UserModel user = getIntent().getParcelableExtra("user");
            viewModel = new HomeViewModel(user);
            homeBinding.setViewModel(viewModel);
        }
    }
}
