package com.example.mustinfohub;
//This class binds the data to the views in the RecyclerView
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<Post> postList;
    // URL for the MUST logo
    private final String LOGO_URL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGNHfE2QMsFCtti43ZLQdHJ5iJfBTtHcBnEw&s";

    public PostAdapter(List<Post> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.tvTitle.setText(post.getTitle());
        holder.tvBody.setText(post.getBody());

        // Use Glide to load the MUST logo into the ImageView
        Glide.with(holder.itemView.getContext())
                .load(LOGO_URL)
                .placeholder(R.mipmap.ic_launcher) // Show a default image while loading
                .into(holder.ivLogo);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvBody;
        ImageView ivLogo;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvBody = itemView.findViewById(R.id.tvBody);
            ivLogo = itemView.findViewById(R.id.ivLogo);
        }
    }
}
