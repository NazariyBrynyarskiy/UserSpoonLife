package dataaccess.dbmanagers.entities;

public class News {
    private String news_title;
    private String news_text;
    private String publication_data;

    public News(String news_title, String news_text, String publication_data) {
        this.news_title = news_title;
        this.news_text = news_text;
        this.publication_data = publication_data;
    }

    public String getNews_title() { return news_title; }
    public String getNews_text() { return news_text; }
    public String getPublication_data() { return publication_data; }

}
