package anum.databinding.service;

import android.os.Handler;

import anum.databinding.data.AppRepository;

public class AppRepositoryMockImpl implements AppRepository {
    private static int DELAY = 3000;

    @Override
    public void loginUser(String username, String password, final ServiceCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.successExecution(MockResponse.getUserData());
            }
        }, DELAY);
    }

    @Override
    public void getLocations(final ServiceCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.successExecution(MockResponse.getPlaces());
            }
        }, DELAY);
    }
}
