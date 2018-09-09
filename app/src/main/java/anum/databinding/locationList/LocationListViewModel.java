package anum.databinding.locationList;

import android.databinding.BaseObservable;

import java.util.ArrayList;

import anum.databinding.models.PlaceModel;
import anum.databinding.service.AppRepositoryMockImpl;
import anum.databinding.service.ServiceCallback;

public class LocationListViewModel extends BaseObservable {

    private ArrayList<PlaceModel> list = new ArrayList<>();
    private LocationListHandler callback;

    public ArrayList<PlaceModel> getList() {
        return list;
    }

    public void setCallback(LocationListHandler callback) {
        this.callback = callback;
    }

    public void fetchPlacesList() {
        new AppRepositoryMockImpl().getLocations(new ServiceCallback() {
            @Override
            public void successExecution(Object response) {
                list = (ArrayList<PlaceModel>) response;
                callback.updateItems(list);
            }
        });
    }
}
