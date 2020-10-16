package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class carti_imprumutate extends AppCompatActivity {

   public static final String Book_added="new book";
   private EditText etNewBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carti_imprumutate);
        etNewBook=findViewById(R.id.etNewBook);

        Button button=findViewById(R.id.btnAdd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent();

                if(TextUtils.isEmpty(etNewBook.getText())){
                    setResult(RESULT_CANCELED, intent);
                }else
                {
                    String books=etNewBook.getText().toString();
                    intent.putExtra(Book_added, books);
                    setResult(RESULT_OK, intent);
                }
                finish();
            }
        });
    }
}
