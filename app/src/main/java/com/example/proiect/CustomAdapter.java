package com.example.proiect;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Book> {
    private Activity context;
    private List<Book> bookList;

    public CustomAdapter(Activity context, List<Book> bookList) {
        super(context, R.layout.layout_books, bookList);
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.layout_books, null, true);
        Book Book=bookList.get(position);

        TextView t1=view.findViewById(R.id.book_titlu);
        TextView t2=view.findViewById(R.id.book_autor);
        TextView t3=view.findViewById(R.id.book_categorie);
        TextView t4=view.findViewById(R.id.book_issn);

        t1.setText("Titlu:"+Book.getTitlu());
        t2.setText("Autor:"+Book.getAutor());
        t3.setText("Parere:"+Book.getCategorie());
        t4.setText("ISSN:"+Book.getIssn());

        return view;
    }
}
