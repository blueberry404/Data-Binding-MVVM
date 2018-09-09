package anum.databinding.login;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginViewModelSimpleTests {

    LoginViewModel viewModel;

    @Before
    public void setup() {
        //Real instance required instead of mock. Otherwise all assertions will fail.
        viewModel = new LoginViewModel(null, null);
    }

    @Test
    public void isValidUsernameAndPassword_invalidUsername() {
        Assert.assertFalse(viewModel.isValidUsernameAndPassword(null, "password"));
    }

    @Test
    public void isValidUsernameAndPassword_invalidPassword() {
        Assert.assertFalse(viewModel.isValidUsernameAndPassword("Randomuser", null));
    }

    @Test
    public void isValidUsernameAndPassword_validUsernamePassword() {
        Assert.assertTrue(viewModel.isValidUsernameAndPassword("user", "pass"));
    }

    @After
    public void tearDown() {
        viewModel = null;
    }
}
