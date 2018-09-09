package anum.databinding.home;

import anum.databinding.models.User;
import anum.databinding.utils.CommonUtils;

public class HomeViewModel {

    User user;

    public HomeViewModel(User user) {
        this.user = user;
    }

    public String getName() {
        StringBuilder builder = new StringBuilder();
        if(!CommonUtils.isNullOrEmptyString(user.getFirstname()))
            builder.append(user.getFirstname());
        if(!CommonUtils.isNullOrEmptyString(user.getLastname())) {
            if(builder.length() > 0)
                builder.append(" ");
            builder.append(user.getLastname());
        }
        return builder.toString();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public String getTenure() {
        return String.format("%d years",user.getTenure());
    }
}
