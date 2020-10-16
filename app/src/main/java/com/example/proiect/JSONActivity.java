package com.example.proiect;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class JSONActivity extends ListActivity {

    private ProgressDialog pDialog;

    private static final String TAG_BOOKS = "books";
    private static final String TAG_DATA = "data";
    private static final String TAG_TITLE = "title";
    private static final String TAG_AUTHOR = "author";
    private static final String TAG_PGS = "nb_of_pgs";
    private static final String TAG_CATEGORY = "category";

    JSONArray books = null;
    ArrayList<HashMap<String, String>> booksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        booksList = new ArrayList<HashMap<String, String>>();
        URL url = null;
        try {
            url = new URL("https://api.myjson.com/bins/121wee");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        GetBooks b = new GetBooks();
        b.setOnTaskFinishedEvent(new OnTaskExecutionFinished() {
            @Override
            public void OnTaskFinishedEvent(String result) {
                if (pDialog.isShowing()) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pDialog.dismiss();
                }
                ListAdapter adapter = new SimpleAdapter(
                        JSONActivity.this,
                        booksList,
                        R.layout.list_item,
                        new String[]{
                                TAG_DATA,
                                TAG_TITLE,
                                TAG_AUTHOR,
                                TAG_PGS,
                                TAG_CATEGORY
                        }, new int[]{
                                R.id.data_imprumut,
                        R.id.title,
                        R.id.author,
                        R.id.nb_of_pgs,
                        R.id.category}
                )
                {
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);
                        HashMap<String, String> currentRow = booksList.get(position);


                        return view;
                    }
                };
                setListAdapter(adapter);
            }
        });
        b.execute(url);
    }

    public interface OnTaskExecutionFinished {
        void OnTaskFinishedEvent(String result);
    }

    public class GetBooks extends AsyncTask<URL, Void, String> {

        public OnTaskExecutionFinished event;

        public void setOnTaskFinishedEvent(OnTaskExecutionFinished _event) {
            if (_event != null) {
                this.event = _event;
            }
        }

        @Override
        protected String doInBackground(URL... urls) {
            HttpURLConnection conn = null;

            try {

                conn = (HttpURLConnection) urls[0].openConnection();
                conn.setRequestMethod("GET");
                InputStream ist = conn.getInputStream();
                InputStreamReader isr = new InputStreamReader(ist);

                BufferedReader br = new BufferedReader(isr);
                String sbuf = "";
                String linieNoua = "";
                while ((linieNoua = br.readLine()) != null) {
                    sbuf += linieNoua;
                }
                loadJSONObject(sbuf);
                return sbuf;
            } catch (Exception e) {

                Log.e("doInBackground", e.getMessage());

            } finally {
                if (conn != null)
                    conn.disconnect();
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(JSONActivity.this);
            pDialog.setMessage("Va rugam asteptati...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (this.event != null) {
                this.event.OnTaskFinishedEvent(s);
            } else {
                Log.d("GetBooks", "task finished event is null");
            }
        }

        public void loadJSONObject(String jsonStr) {
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = null;
                    try {
                        jsonObj = new JSONObject(jsonStr);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    books = jsonObj.getJSONArray(TAG_BOOKS);

                    for (int i = 0; i < books.length(); i++) {
                        JSONObject c = books.getJSONObject(i);
                        String data = c.getString(TAG_DATA);
                        String title = c.getString(TAG_TITLE);
                        String author = c.getString(TAG_AUTHOR);
                        String nb_of_pgs = c.getString(TAG_PGS);
                        String category = c.getString(TAG_CATEGORY);


                        HashMap<String, String> book = new HashMap<String, String>();
                        book.put(TAG_DATA, data);
                        book.put(TAG_TITLE, title);
                        book.put(TAG_AUTHOR, author);
                        book.put(TAG_PGS, nb_of_pgs);
                        book.put(TAG_CATEGORY, category);

                        booksList.add(book);


                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("loadJSONObject", "Couldn't get any data");
            }
        }
    }
}
