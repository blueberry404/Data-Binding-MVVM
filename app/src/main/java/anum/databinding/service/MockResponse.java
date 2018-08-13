package anum.databinding.service;

import anum.databinding.models.UserModel;

public class MockResponse {

    public static UserModel getUserData() {
        UserModel user = new UserModel("David", "Henry",
                "david.henry@gmail.com", 3);
        return user;
    }
}
