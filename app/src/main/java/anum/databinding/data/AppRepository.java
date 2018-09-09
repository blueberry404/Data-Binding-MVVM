package anum.databinding.data;

import anum.databinding.models.PlaceModel;
import anum.databinding.models.User;
import anum.databinding.service.ServiceCallback;

public interface AppRepository {

    void loginUser(String username, String password, ServiceCallback<User> callback);

    void getLocations(ServiceCallback<PlaceModel> callback);
}
