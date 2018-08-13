package anum.databinding.service;

import android.os.Handler;

public class MockService {
    private static int DELAY = 2000;

    public void loginUser(String username, String password, final ServiceCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.successExecution(MockResponse.getUserData());
            }
        }, DELAY);
    }
}
