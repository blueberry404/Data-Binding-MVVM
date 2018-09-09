package anum.databinding.home;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import anum.databinding.R;
import anum.databinding.databinding.ActivityHomeBinding;
import anum.databinding.locationList.LocationListActivity;
import anum.databinding.models.User;

public class HomeActivity extends AppCompatActivity implements HomeHandler {

    ActivityHomeBinding homeBinding;
    HomeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        homeBinding.setCallback(this);
        populateUserInitials();
    }

    void populateUserInitials() {
        if(getIntent() != null) {
            User user = getIntent().getParcelableExtra("user");
            viewModel = new HomeViewModel(user);
            homeBinding.setViewModel(viewModel);
        }
    }

    @Override
    public void onNextButtonClick() {
        startActivity(new Intent(this, LocationListActivity.class));
    }
}
