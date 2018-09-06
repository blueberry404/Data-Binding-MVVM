package anum.databinding.utils;

import org.junit.Assert;
import org.junit.Test;

//@RunWith(MockitoJUnitRunner.class)
public class CommonUtilsTest {

    @Test
    public void NullString() {
        Assert.assertTrue(CommonUtils.isNullOrEmptyString(null));
    }

    @Test
    public void EmptyString() {
        Assert.assertTrue(CommonUtils.isNullOrEmptyString(""));
    }

    @Test
    public void NonEmptyString() {
        Assert.assertFalse(CommonUtils.isNullOrEmptyString("An43u297"));
    }
}
