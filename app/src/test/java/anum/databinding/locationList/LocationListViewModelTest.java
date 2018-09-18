package anum.databinding.locationList;

import org.hamcrest.Matchers;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import anum.databinding.models.PlaceModel;
import anum.databinding.service.AppRepositoryMockImpl;
import anum.databinding.service.ServiceCallback;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LocationListViewModelTest {

    @Mock
    AppRepositoryMockImpl repositoryMock;

    @Mock
    LocationListHandler callback;

    LocationListViewModel viewModel;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        viewModel = new LocationListViewModel(repositoryMock);
        viewModel.setCallback(callback);
    }

    @Test
    public void checkListPopulatedOnCallback() {
        ArgumentCaptor<ServiceCallback<ArrayList<PlaceModel>>> capture = ArgumentCaptor.forClass(ServiceCallback.class);

        viewModel.fetchPlacesList();
        //check if getLocations() was invoked
        verify(repositoryMock).getLocations(capture.capture());

       //Pass arraylist to callback response
        ServiceCallback<ArrayList<PlaceModel>> aCallback = capture.getValue();
        ArrayList<PlaceModel> list = new ArrayList<>();
        PlaceModel placeModel = new PlaceModel("NAme", "http://url.com", "Details");
        list.add(placeModel);
        aCallback.successExecution(list);

        //check if viewModel has now items
        Assert.assertNotNull(viewModel.getList());

        //check if callback was invoked
        verify(callback, times(1)).updateItems(list);

        //verify list item
        //using Hamcrest
        Assert.assertThat(list.toArray(), is(arrayWithSize(1)));
        Assert.assertThat(list.toArray(), Matchers.<Object>hasItemInArray(placeModel));
        Assert.assertThat(list, hasItem(placeModel));
        Assert.assertThat(list, is(notNullValue()));
    }
}
