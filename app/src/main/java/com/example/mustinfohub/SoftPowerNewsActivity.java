//package com.example.mustinfohub;
//
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Looper;
//import android.view.View;
//import android.widget.ProgressBar;
//import android.widget.Toast;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class SoftPowerNewsActivity extends AppCompatActivity {
//
//    private RecyclerView recyclerView;
//    private ProgressBar progressBar;
//    private ArticleAdapter adapter;
//    private final List<Article> articleList = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_soft_power_news);
//
//        recyclerView = findViewById(R.id.newsRecyclerView);
//        progressBar = findViewById(R.id.progressBar);
//
//        setupRecyclerView();
//        fetchNews();
//    }
//
//    private void setupRecyclerView() {
//        adapter = new ArticleAdapter(this, articleList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);
//    }
//
//    private void fetchNews() {
//        // Use an Executor to run the task in the background
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        Handler handler = new Handler(Looper.getMainLooper());
//
//        executor.execute(() -> {
//            // Background work starts here
//            try {
//                final List<Article> scrapedArticles = new ArrayList<>();
//                final Document doc = Jsoup.connect("https://softpower.ug/").get();
//                //final Document doc = Jsoup.connect("https://chimpreports.com/").get();
//
//
//                // This selector targets each article block on the SoftPower homepage
//                Elements articles = doc.select("article.post-item");
//
//                for (Element articleElement : articles) {
//                    // This selector gets the title and the link to the full article
//                    Element titleElement = articleElement.selectFirst("h2.post-title a");
//                    String title = titleElement.text();
//                    String articleUrl = titleElement.attr("href");
//
//                    // This gets the image URL from the 'img' tag
//                    Element imageElement = articleElement.selectFirst("div.post-thumb img");
//                    String imageUrl = imageElement.attr("src");
//
//                    // Add the scraped data to our list
//                    scrapedArticles.add(new Article(title, imageUrl, articleUrl));
//                }
//
//                // UI thread work starts here
//                handler.post(() -> {
//                    articleList.clear();
//                    articleList.addAll(scrapedArticles);
//                    adapter.notifyDataSetChanged();
//                    progressBar.setVisibility(View.GONE);
//                    recyclerView.setVisibility(View.VISIBLE);
//                });
//
//            } catch (IOException e) {
//                // If something goes wrong, show an error message
//                handler.post(() -> {
//                    progressBar.setVisibility(View.GONE);
//                    Toast.makeText(SoftPowerNewsActivity.this, "Failed to load news.", Toast.LENGTH_LONG).show();
//                });
//            }
//        });
//    }
//}