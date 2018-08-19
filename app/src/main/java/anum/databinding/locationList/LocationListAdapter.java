package anum.databinding.locationList;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import anum.databinding.R;
import anum.databinding.databinding.ItemLocationListBinding;
import anum.databinding.listeners.LocationListener;

public class LocationListAdapter extends RecyclerView.Adapter<LocationListViewHolder> {

    private Context context;
    private LocationListener listener;
    private final ObservableArrayList<LocationListItemViewModel> list = new ObservableArrayList<>();

    public LocationListAdapter(Context context, LocationListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public LocationListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLocationListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.item_location_list, parent, false);
        return new LocationListViewHolder(binding, listener);
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
