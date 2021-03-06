package com.example.lutsak.recycleview_gridlayoutmanager.adapter;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.lutsak.recycleview_gridlayoutmanager.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.ViewHolder> {

    private static final String TAG = LinearAdapter.class.getSimpleName();

    private ArrayList<String> mImages;

    //todo; remove activity from here
    public LinearAdapter(ArrayList<String> images){
        this.mImages = images;
    }


    /* This method return ViewHolder with parameter view, got using LayoutInflater */
    @Override
    public LinearAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_container, parent, false);
        return new ViewHolder(view);
    }

    /*
     * This method use Picasso library, his work is to take an image from web source and set to
     * our ImageView.
     */
    @Override
    public void onBindViewHolder(LinearAdapter.ViewHolder holder, int position) {
        Log.d(TAG, "onBindingViewHolder width : " + holder.image.getLayoutParams().width);
        Log.d(TAG, "onBindingViewHolder high : " + holder.image.getLayoutParams().height);

        Picasso.with(holder.itemView.getContext())
                .load(mImages.get(position))
                .placeholder(R.drawable.loading)
                .into((holder.image));
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;

        @SuppressWarnings("SuspiciousNameCombination")
        ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_view_container);
            image.getLayoutParams().height = Resources.getSystem().getDisplayMetrics().widthPixels;
            Log.d(TAG, " ViewHolder width : " + image.getLayoutParams().width);
            Log.d(TAG, " ViewHolder height : " + image.getLayoutParams().height);
        }
    }
}
