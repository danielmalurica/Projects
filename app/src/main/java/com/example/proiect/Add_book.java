package com.example.proiect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class Add_book extends AppCompatActivity {

    private EditText edt_titlu;
    private EditText edt_autor;
    private EditText edt_issn;
    private EditText edt_categorie;
    private Button btn_add, load_books;

    DatabaseReference ref;
    Book book;
    long maxid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        edt_titlu = (EditText) findViewById(R.id.add_titlu);
        edt_autor = (EditText) findViewById(R.id.add_autor);
        edt_issn = (EditText) findViewById(R.id.add_issn);
        edt_categorie = (EditText) findViewById(R.id.add_categorie);

        btn_add = (Button) findViewById(R.id.add_buton);
        load_books = (Button) findViewById(R.id.btn_books);

        book = new Book();

        ref = FirebaseDatabase.getInstance().getReference().child("Book");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxid=(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int n=Integer.parseInt(edt_issn.getText().toString());
                book.setTitlu(edt_titlu.getText().toString().trim());
                book.setAutor(edt_autor.getText().toString().trim());
                book.setCategorie(edt_categorie.getText().toString().trim());
                book.setIssn(n);

                ref.child(String.valueOf(maxid+1)).setValue(book);


                Toast.makeText(Add_book.this,"Carte adaugata cu succes!", Toast.LENGTH_LONG).show();
            }
        });

        load_books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Add_book.this, books_read.class);
                startActivity(intent);
            }
        });

    }
}
