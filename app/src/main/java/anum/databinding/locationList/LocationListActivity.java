package anum.databinding.locationList;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;

import anum.databinding.R;
import anum.databinding.databinding.ActivityLocationListBinding;
import anum.databinding.listeners.LocationListener;
import anum.databinding.models.PlaceModel;

public class LocationListActivity extends AppCompatActivity implements LocationListener {

    ActivityLocationListBinding binding;
    LocationListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_location_list);
        viewModel = new LocationListViewModel();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initializeData();
        viewModel.fetchPlacesList();
    }

    void initializeData() {
        LocationListAdapter adapter = new LocationListAdapter(this, this);
        binding.locationList.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        binding.locationList.setAdapter(adapter);
    }

    @Override
    public void onClickLocation(PlaceModel model) {

    }
}
