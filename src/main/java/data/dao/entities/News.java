package data.dao.entities;

public class News {
    private final String NEWS_TITLE;
    private final String NEWS_TEXT;
    private final String PUBLICATION_DATA;

    public News(String NEWS_TITLE, String NEWS_TEXT, String PUBLICATION_DATA) {
        this.NEWS_TITLE = NEWS_TITLE;
        this.NEWS_TEXT = NEWS_TEXT;
        this.PUBLICATION_DATA = PUBLICATION_DATA;
    }

    public String getNews_title() { return NEWS_TITLE; }
    public String getNews_text() { return NEWS_TEXT; }
    public String getPublication_data() { return PUBLICATION_DATA; }

}
