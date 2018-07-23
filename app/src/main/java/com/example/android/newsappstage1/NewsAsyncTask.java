package com.example.android.newsappstage1;

import android.os.AsyncTask;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class NewsAsyncTask extends AsyncTask<String, Void, List<News>> {

    /**
     * This method runs on a background thread and performs the network request.
     * We should not update the UI from a background thread, so we return a list of
     * {@link News} as the result.
     */
    @Override
    protected List<News> doInBackground(String... urls) {
        // Don't perform the request if there are no URLs, or the first URL is null.
        if (urls.length < 1 || urls[0] == null) {
            return null;
        }

        List<News> result = NewsUtils.fetchNewsData(urls[0]);
        return result;
    }

    /**
     * This method runs on the main UI thread after the background work has been
     * completed. This method receives as input, the return value from the doInBackground()
     * method. First we clear out the adapter, to get rid of earthquake data from a previous
     * query to News. Then we update the adapter with the new list of news articles,
     * which will trigger the ListView to re-populate its list items.
     */
    @Override
    protected void onPostExecute(List<News> data) {
        // Clear the adapter of previous earthquake data
        CopyOnWriteArrayList mAdapter = new CopyOnWriteArrayList();
        mAdapter.clear();

        // If there is a valid list of {@link News}, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (data != null && !data.isEmpty()) {
            mAdapter.addAll(data);
        }
    }
}