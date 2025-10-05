package com.example.mustinfohub;

//Create a new Java class to hold the information for each scraped article.
public class Article {
    private final String title;
    private final String imageUrl;
    private final String articleUrl;
    private final String summary;

    public Article(String title, String summary, String imageUrl, String articleUrl) {
        this.title = title;
        this.summary = summary;
        this.imageUrl = imageUrl;
        this.articleUrl = articleUrl;
    }

    public String getTitle() {
        return title;
    }
    public String getSummary() {
        return summary; }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getArticleUrl() {
        return articleUrl;
    }
}