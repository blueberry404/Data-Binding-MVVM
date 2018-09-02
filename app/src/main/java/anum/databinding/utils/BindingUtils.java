package anum.databinding.utils;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;

import anum.databinding.locationList.LocationListAdapter;
import anum.databinding.models.PlaceModel;

public final class BindingUtils {

    @BindingAdapter("adapter")
    public static void setLocationListAdapter(RecyclerView recyclerView, ArrayList<PlaceModel> list) {
        LocationListAdapter adapter = (LocationListAdapter) recyclerView.getAdapter();
        if(list != null)
            adapter.setItems(list);
    }

    @BindingAdapter(value={"imageURL", "placeholder"}, requireAll=false)
    public static void setImageURL(ImageView imageView, String url, Drawable placeholder) {
        if(url != null) {
            GlideApp
                    .with(imageView.getContext())
                    .load(url)
                    .placeholder(placeholder)
                    .sizeMultiplier(0.5f)
                    .into(imageView);
        }
        else
            imageView.setImageDrawable(placeholder);
    }
}
