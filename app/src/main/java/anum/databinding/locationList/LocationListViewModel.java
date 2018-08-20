package anum.databinding.locationList;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import java.util.ArrayList;
import java.util.List;

import anum.databinding.models.PlaceModel;
import anum.databinding.service.MockService;
import anum.databinding.service.ServiceCallback;

public class LocationListViewModel extends BaseObservable {

    private ArrayList<LocationListItemViewModel> list = new ArrayList<>();
    private LocationListHandler callback;

    public ArrayList<LocationListItemViewModel> getList() {
        return list;
    }

    public void setCallback(LocationListHandler callback) {
        this.callback = callback;
    }

    public void fetchPlacesList() {
        new MockService().getLocations(new ServiceCallback() {
            @Override
            public void successExecution(Object response) {
                createViewholdersFromData((List<PlaceModel>) response);
                callback.updateItems(list);
            }
        });
    }

    void createViewholdersFromData(List<PlaceModel> placeModels) {
        for(PlaceModel model : placeModels) {
            LocationListItemViewModel itemViewModel = new LocationListItemViewModel(model);
            list.add(itemViewModel);
        }
    }
}
