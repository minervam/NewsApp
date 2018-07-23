package com.example.android.newsappstage1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * A {@link NewsAdapter} knows how to create a list item layout for each news article
 * in the data source (a list of {@link News} objects).
 * <p>
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param news    is the list of news articles, which is the data source of the adapter
     */
    public NewsAdapter(Context context, ArrayList<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the earthquake at the given position
     * in the list of news articles.
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        final ViewHolder holder;
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item,
                    parent, false);
            holder = new ViewHolder(listItemView);
            listItemView.setTag(holder);
        } else {
            holder = (ViewHolder) listItemView.getTag();
        }

        // Find the news article at the given position in the list of news articles
        News currentNews = getItem(position);

        Picasso.get().load(currentNews.getImage()).into(holder.ImageView);

        // Find the TextView with view ID section and display it
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);
        String section = currentNews.getSection();
        sectionView.setText(section);

        // Find the TextView with title and display it
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        String title = currentNews.getTitle();
        titleView.setText(title);

        // Find the TextView with view ID contributor and display it
        TextView contributorView = (TextView) listItemView.findViewById(R.id.contributor);
        String contributor = currentNews.getContributor();
        contributorView.setText(contributor);

        // Find the TextView with view ID date and display it
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        String date = currentNews.getDate();
        dateView.setText(date);
        return listItemView;
    }
}

class ViewHolder {

    public ImageView ImageView;

    public ViewHolder(View listItemView) {
        ImageView = listItemView.findViewById(R.id.image);
    }
}
