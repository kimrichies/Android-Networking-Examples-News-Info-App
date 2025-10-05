package com.example.mustinfohub;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private final List<Article> articleList;
    private final Context context;

    public ArticleAdapter(Context context, List<Article> articleList) {
        this.context = context;
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articleList.get(position);
        holder.titleTextView.setText(article.getTitle());
        holder.summaryTextView.setText(article.getSummary()); // Set the summary text

        Glide.with(context)
                .load(article.getImageUrl())
                .placeholder(R.drawable.ic_launcher_background) // A default placeholder
                .error(R.drawable.ic_launcher_background)       // Image on error
                .into(holder.imageView);

        // Handle item clicks
        holder.itemView.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(article.getArticleUrl()));
            context.startActivity(browserIntent);
        });
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    static class ArticleViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView, summaryTextView;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.articleImageView);
            titleTextView = itemView.findViewById(R.id.articleTitleTextView);
            summaryTextView = itemView.findViewById(R.id.articleSummaryTextView); // Find the new view
        }
    }
}
