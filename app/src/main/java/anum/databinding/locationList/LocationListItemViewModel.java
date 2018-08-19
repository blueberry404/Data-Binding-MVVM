package anum.databinding.locationList;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import anum.databinding.BR;
import anum.databinding.models.PlaceModel;

public class LocationListItemViewModel extends BaseObservable {

    PlaceModel placeModel;

    /*
    * For demo, both ObservableField and @Binding variables are used.
    * */
    private String locationTitle;

    public ObservableField<String> locationDetails = new ObservableField<>();
    public ObservableField<String> imageURL = new ObservableField<>();

    public LocationListItemViewModel(PlaceModel placeModel) {
        this.placeModel = placeModel;
        this.locationTitle = placeModel.getName();
        this.locationDetails.set(placeModel.getDetails());
        this.imageURL.set(placeModel.getUrl());
    }

    @Bindable
    public String getLocationTitle() {
        return locationTitle;
    }

    public void setLocationTitle(String locationTitle) {
        this.locationTitle = locationTitle;
        notifyPropertyChanged(BR.locationTitle);
    }
}
