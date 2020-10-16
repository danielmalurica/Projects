package com.example.proiect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class books_read extends AppCompatActivity {
   private ListView listView;
   DatabaseReference databaseReference;
   private List<Book> bookList;
   private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_read);



        databaseReference=FirebaseDatabase.getInstance().getReference("Book");
        bookList=new ArrayList<>();

        customAdapter=new CustomAdapter(books_read.this, bookList);

        listView=findViewById(R.id.listView_books);


    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                bookList.clear();
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    Book book=dataSnapshot1.getValue(Book.class);
                    bookList.add(book);
                }
                listView.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
}
