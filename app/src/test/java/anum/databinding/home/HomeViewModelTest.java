package anum.databinding.home;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import anum.databinding.models.User;

import static org.mockito.Mockito.when;

public class HomeViewModelTest {

    @Mock
    User user;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testCheckInitializedObjectNotNull() {
        HomeViewModel model = new HomeViewModel(user);
        Assert.assertNotNull(model.user);
    }

    @Test
    public void testCheckInitializedObjectIsNull() {
        HomeViewModel model = new HomeViewModel(null);
        Assert.assertNull(model.user);
    }

    @Test
    public void testCheckFirstname_LastnameNull() {
        HomeViewModel model = new HomeViewModel(user);
        when(user.getFirstname()).thenReturn("Anum");
        when(user.getLastname()).thenReturn(null);
        Assert.assertEquals("Anum", model.getName());
    }

    @Test
    public void testCheckFirstname_LastnameEmpty() {
        HomeViewModel model = new HomeViewModel(user);
        when(user.getFirstname()).thenReturn("Anum");
        when(user.getLastname()).thenReturn("");
        Assert.assertEquals("Anum", model.getName());
    }

    @Test
    public void testCheckFirstnameNull_Lastname() {
        HomeViewModel model = new HomeViewModel(user);
        when(user.getFirstname()).thenReturn(null);
        when(user.getLastname()).thenReturn("Amin");
        Assert.assertEquals("Amin", model.getName());
    }

    @Test
    public void testCheckFirstnameEmpty_Lastname() {
        HomeViewModel model = new HomeViewModel(user);
        when(user.getFirstname()).thenReturn("");
        when(user.getLastname()).thenReturn("Amin");
        Assert.assertEquals("Amin", model.getName());
    }

    @Test
    public void testCheckFirstname_Lastname() {
        HomeViewModel model = new HomeViewModel(user);
        when(user.getFirstname()).thenReturn("Anum");
        when(user.getLastname()).thenReturn("Amin");
        Assert.assertEquals("Anum Amin", model.getName());
    }

    @Test
    public void testCheckEmailNull() {
        HomeViewModel model = new HomeViewModel(user);
        when(user.getEmail()).thenReturn(null);
        Assert.assertNull(model.getEmail());
    }

    @Test
    public void testCheckEmailEmpty() {
        HomeViewModel model = new HomeViewModel(user);
        when(user.getEmail()).thenReturn("");
        Assert.assertEquals("", model.getEmail());
    }

    @Test
    public void testCheckCorrectEmail() {
        HomeViewModel model = new HomeViewModel(user);
        when(user.getEmail()).thenReturn("test@test.com");
        Assert.assertEquals("test@test.com", model.getEmail());
    }

    @Test
    public void testCheckNullTenure() {
        HomeViewModel model = new HomeViewModel(user);
        when(user.getTenure()).thenReturn(0);
        Assert.assertEquals("0 years", model.getTenure());
    }

    @Test
    public void testCheckIntegerTenure() {
        HomeViewModel model = new HomeViewModel(user);
        when(user.getTenure()).thenReturn(23);
        Assert.assertEquals("23 years", model.getTenure());
    }

    @Test
    public void testCheckLargeIntTenure() {
        HomeViewModel model = new HomeViewModel(user);
        when(user.getTenure()).thenReturn(230000);
        Assert.assertEquals("230000 years", model.getTenure());
    }
}
