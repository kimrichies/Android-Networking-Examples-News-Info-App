package com.example.mustinfohub;
//Scrapping page
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MustNewsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ArticleAdapter adapter;
    private final List<Article> articleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_must_news);

        recyclerView = findViewById(R.id.newsRecyclerView);
        progressBar = findViewById(R.id.progressBar);

        setupRecyclerView();
        fetchNews();
    }

    // setupRecyclerView() method remains the same...
    private void setupRecyclerView() {
        adapter = new ArticleAdapter(this, articleList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void fetchNews() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            try {
                final List<Article> scrapedArticles = new ArrayList<>();
                final Document doc = Jsoup.connect("https://must.ac.ug/news/").get();

                Elements articles = doc.select("article.elementor-post");

                for (Element articleElement : articles) {
                    Element titleElement = articleElement.selectFirst("h3.elementor-post__title a");
                    Element imageElement = articleElement.selectFirst("div.elementor-post__thumbnail img");
                    Element summaryElement = articleElement.selectFirst("div.elementor-post__excerpt p");

                    if (titleElement != null && imageElement != null && summaryElement != null) {
                        String title = titleElement.text();
                        String articleUrl = titleElement.attr("href");
                        String imageUrl = imageElement.attr("src");
                        String summary = summaryElement.text();

                        scrapedArticles.add(new Article(title, summary, imageUrl, articleUrl));
                    }
                }

                handler.post(() -> {
                    // Update UI
                    articleList.clear();
                    articleList.addAll(scrapedArticles);
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                });

            } catch (IOException e) {
                handler.post(() -> {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(MustNewsActivity.this, "Failed to load news.", Toast.LENGTH_LONG).show();
                });
            }
        });
    }
}