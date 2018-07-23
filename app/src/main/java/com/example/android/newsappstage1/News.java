package com.example.android.newsappstage1;

public class News {

    /**
     * Image of the news article
     */
    private String mImageUrl;
    /**
     * Section of the news article
     */
    private String mSection;

    /**
     * Title of the news article
     */
    private String mTitle;

    /**
     * Contributor of the news article
     */
    private String mContributor;

    /**
     * Date of the news article
     */
    private String mDate;

    /**
     * Website URL of the news article
     */
    private String mUrl;

    /**
     * Constructs a new {@link News} object.
     * @param image       is the image of the article
     * @param section     is the new section
     * @param title       is the name of the article
     * @param contributor is the author of the article
     * @param date is the date of the article
     * @param url         is the website URL to find more details about the news article
     */

    public News(String image, String section, String title, String contributor,
                String date, String url) {
        mImageUrl = image;
        mSection = section;
        mTitle = title;
        mContributor = contributor;
        mDate = date;
        mUrl = url;
    }

    /**
     * Returns the image of the news article
     */
    public String getImage() {
        return mImageUrl;
    }

    /**
     * Returns the section of the news article
     */
    public String getSection() {
        return mSection;
    }

    /**
     * Returns the title of the news article.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns the author of the news article.
     */
    public String getContributor() {

        return mContributor;
    }

    /**
     * Returns the date of the news article.
     */
    public String getDate() {
        return mDate; }

    /**
     * Returns the website URL to find more information about news article.
     */
    public String getUrl() {
        return mUrl; }
}
