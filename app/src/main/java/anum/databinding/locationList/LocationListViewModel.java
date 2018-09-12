package anum.databinding.locationList;

import android.databinding.BaseObservable;

import java.util.ArrayList;

import anum.databinding.data.AppRepository;
import anum.databinding.models.PlaceModel;
import anum.databinding.service.AppRepositoryMockImpl;
import anum.databinding.service.ServiceCallback;

public class LocationListViewModel extends BaseObservable {

    private ArrayList<PlaceModel> list = new ArrayList<>();
    private LocationListHandler callback;
    private AppRepository repository;

    public LocationListViewModel(AppRepository repository) {
        this.repository = repository;
    }

    public ArrayList<PlaceModel> getList() {
        return list;
    }

    public void setCallback(LocationListHandler callback) {
        this.callback = callback;
    }

    public void fetchPlacesList() {
        repository.getLocations(new ServiceCallback() {
            @Override
            public void successExecution(Object response) {
                list = (ArrayList<PlaceModel>) response;
                callback.updateItems(list);
            }
        });
    }
}
