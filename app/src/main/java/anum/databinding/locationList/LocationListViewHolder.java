package anum.databinding.locationList;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import anum.databinding.databinding.ItemLocationBinding;
import anum.databinding.listeners.LocationListener;

public class LocationListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ItemLocationBinding binding;
    private LocationListItemViewModel viewModel;
    private LocationListener listener;

    public LocationListViewHolder(ItemLocationBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    public void populateData(LocationListItemViewModel itemViewModel) {
        binding.setVm(itemViewModel); // setVariable(BR.place, place) would also work
        /*
        * This forces the bindings to run immediately instead of delaying them until the next frame.
        * RecyclerView will measure the view immediately after onBindViewHolder. */
        binding.executePendingBindings();
    }

    @Override
    public void onClick(View v) {
//        this.listener.onClickLocation(binding.getViewModel());
    }
}
