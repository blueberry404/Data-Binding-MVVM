package anum.databinding.Home;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import anum.databinding.R;
import anum.databinding.models.UserModel;
import anum.databinding.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding homeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        if(getIntent() != null)
            homeBinding.setUser((UserModel) getIntent().getParcelableExtra("user"));
    }
}
