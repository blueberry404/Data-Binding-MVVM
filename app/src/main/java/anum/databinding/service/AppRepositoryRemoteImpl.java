package anum.databinding.service;

import android.os.Handler;

import anum.databinding.data.AppRepository;
import anum.databinding.models.PlaceModel;
import anum.databinding.models.User;

public class AppRepositoryRemoteImpl implements AppRepository {

    private static int DELAY = 3000;

    //Call retrofit APIs here. For now mocking data here as well

    @Override
    public void loginUser(String username, String password, final ServiceCallback<User> callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.successExecution(MockResponse.getUserData());
            }
        }, DELAY);
    }

    @Override
    public void getLocations(final ServiceCallback<PlaceModel> callback) {

    }
}
