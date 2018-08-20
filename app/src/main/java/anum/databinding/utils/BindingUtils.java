package anum.databinding.utils;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import anum.databinding.locationList.LocationListAdapter;
import anum.databinding.locationList.LocationListItemViewModel;

public final class BindingUtils {

    @BindingAdapter("adapter")
    public static void setLocationListAdapter(RecyclerView recyclerView, ArrayList<LocationListItemViewModel> list) {
        LocationListAdapter adapter = (LocationListAdapter) recyclerView.getAdapter();
        if(list != null)
            adapter.setItems(list);
    }

    @BindingAdapter(value={"imageURL", "placeholder"}, requireAll=false)
    public static void setImageURL(ImageView imageView, String url, Drawable placeholder) {
        if(url != null) {
            Picasso.get().load(url).placeholder(placeholder).into(imageView);
        }
        else
            imageView.setImageDrawable(placeholder);
    }
}
