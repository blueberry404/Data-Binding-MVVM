package anum.databinding.locationList;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;

import java.util.ArrayList;

import anum.databinding.R;
import anum.databinding.databinding.ActivityLocationListBinding;
import anum.databinding.models.PlaceModel;

public class LocationListActivity extends AppCompatActivity implements LocationListHandler {

    ActivityLocationListBinding binding;
    LocationListViewModel viewModel;
    LocationListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_location_list);
        viewModel = new LocationListViewModel();
        viewModel.setCallback(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initializeData();
        viewModel.fetchPlacesList();
    }

    void initializeData() {
        adapter = new LocationListAdapter(this);
        binding.locationList.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        binding.locationList.setAdapter(adapter);
    }

    @Override
    public void updateItems(ArrayList<PlaceModel> list) {
        adapter.setItems(list);
    }
}
