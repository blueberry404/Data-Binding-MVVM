package anum.databinding.locationList;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import anum.databinding.R;
import anum.databinding.databinding.ItemLocationBinding;

public class LocationListAdapter extends RecyclerView.Adapter<LocationListViewHolder> {

    private Context context;
    private List<LocationListItemViewModel> list = new ArrayList<>();

    public LocationListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public LocationListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLocationBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.item_location, parent, false);
        return new LocationListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationListViewHolder holder, int position) {
        holder.populateData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setItems(List<LocationListItemViewModel> items) {
        list.addAll(items);
        notifyDataSetChanged();
    }
}
