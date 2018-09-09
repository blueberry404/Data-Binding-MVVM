package anum.databinding.login;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import anum.databinding.service.AppRepositoryMockImpl;
import anum.databinding.service.ServiceCallback;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/*Copy of LoginViewModelMockInitTest. Only testing using @InjectMock annotation*/
@RunWith(MockitoJUnitRunner.class)
public class LoginViewModelMockInjectTest {

    @Mock
    AppRepositoryMockImpl service;

    @Mock
    LoginActivity navigator;

    @InjectMocks
    LoginViewModel model;

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

    @Test
    public void checkIfNavigatorCalledAfterLogin() {
        model.validateUserFromServer("anum", "123");
        Assert.assertNotNull(navigator);
        //TODO: Following line fails
        verify(navigator, atLeast(1)).navigateToHomeScreen(null);
    }

    @Test
    public void checkIfExactParamsPassedToService() {
        model.validateUserFromServer("anum", "123");

        ArgumentCaptor<String> usernameArgumentCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> passwordArgumentCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<ServiceCallback> serviceArgumentCaptor = ArgumentCaptor.forClass(ServiceCallback.class);

        verify(service, times(1))
                .loginUser(usernameArgumentCaptor.capture(),
                        passwordArgumentCaptor.capture(),
                        serviceArgumentCaptor.capture());

        Assert.assertEquals("anum", usernameArgumentCaptor.getValue());
        Assert.assertEquals("123", passwordArgumentCaptor.getValue());
    }

}
