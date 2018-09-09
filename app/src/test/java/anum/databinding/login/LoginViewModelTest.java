package anum.databinding.login;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import anum.databinding.service.MockService;
import anum.databinding.service.ServiceCallback;

@RunWith(MockitoJUnitRunner.class)
public class LoginViewModelTest {

//    @Captor
//    private ArgumentCaptor<ServiceCallback> argumentCaptor;

    @Mock
    MockService service;

    @Mock
    LoginViewModel model;

    @Test
    public void isValidUsernameAndPassword_invalidUsername() {

    }

    @Test
    public void isValidUsernameAndPassword_invalidPassword() {

    }

    @Test
    public void isValidUsernameAndPassword_validUsernamePassword() {

    }

    @Test
    public void checkIfLoginMethodInvoked() {
        model.validateUserFromServer("anum", "123");
        verify(service, times(1))
                .loginUser(anyString(), anyString(), any(ServiceCallback.class));
    }

    @Test
    public void checkIfLoginMethodInvokedAndFinishedWithinTime() {
        model.validateUserFromServer("anum", "123");
        verify(service, timeout(1000))
                .loginUser(anyString(), anyString(), any(ServiceCallback.class));
    }

//    @Test
//    public void checkIfLoginMethodInvoked2() {
//        model.validateUserFromServer("anum", "123");
//
//        ArgumentCaptor<String> usernameArgumentCaptor = ArgumentCaptor.forClass(String.class);
//        ArgumentCaptor<String> passwordArgumentCaptor = ArgumentCaptor.forClass(String.class);
//        ArgumentCaptor<ServiceCallback> serviceArgumentCaptor = ArgumentCaptor.forClass(ServiceCallback.class);
//
//
//        verify(service, times(1))
//                .loginUser(usernameArgumentCaptor.capture(),
//                        passwordArgumentCaptor.capture(),
//                        serviceArgumentCaptor.capture());
//
//        Assert.assertEquals("anum", usernameArgumentCaptor.getValue());
//    }

}
