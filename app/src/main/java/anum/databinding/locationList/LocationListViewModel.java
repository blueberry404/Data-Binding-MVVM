package anum.databinding.locationList;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;

import java.util.List;

import anum.databinding.models.PlaceModel;
import anum.databinding.service.MockService;
import anum.databinding.service.ServiceCallback;

public class LocationListViewModel extends BaseObservable {

    /*
    * Create an observable array
    * OR
    * Declare a simple Arraylist. Use Bindable for getter accessor and notifyPropertyChanged when setting value
    * */
    public final ObservableArrayList<LocationListItemViewModel> list = new ObservableArrayList<>();

    public void fetchPlacesList() {
        new MockService().getLocations(new ServiceCallback() {
            @Override
            public void successExecution(Object response) {
                createViewholdersFromData((List<PlaceModel>) response);
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
