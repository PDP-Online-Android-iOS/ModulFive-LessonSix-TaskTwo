package dev.ogabek.java.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.java.R;
import dev.ogabek.java.activity.MainActivity;
import dev.ogabek.java.model.Image;

public class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Image> images;
    MainActivity mainActivity;

    public ImageAdapter(MainActivity mainActivity, List<Image> images) {
        this.images = images;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Image image = images.get(position);

        if (holder instanceof ImageViewHolder) {
            ((ImageViewHolder) holder).picture.setImageResource(image.getImage());
            mainActivity.setImageHeight(((ImageViewHolder) holder).picture);
        }
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    private class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView picture;

        public ImageViewHolder(View view) {
            super(view);

            picture = view.findViewById(R.id.ll_image);

        }
    }
}
