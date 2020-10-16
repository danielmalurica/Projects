package com.example.proiect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import org.json.JSONArray;

public class
MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       LinearLayout btn1=findViewById(R.id.favorite);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(), JSONActivity.class);
                startActivity(intent);


            }
        });

        LinearLayout btn2=findViewById(R.id.citite);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
//                }
                Intent intent = new Intent(getApplicationContext(), books_read.class);
                startActivity(intent);
            }
        });

        LinearLayout btn3=findViewById(R.id.adauga);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
//                }
                Intent intent = new Intent(getApplicationContext(), Add_book.class);
                startActivity(intent);
            }
        });


    }


    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        switch (id){

           case R.id.c_imprumutate:
                Intent intent=new Intent(this, adaugaImprumutate.class);
               this.startActivity(intent);
               break;
            case R.id.lista:
                Intent intent1=new Intent(this, MapsActivity.class);
                startActivity(intent1);
                break;
           // case R.id.itmRoom:
             //   Intent intent3=new Intent(this, adaugaImprumutate.class);
               // startActivity(intent3);

            case R.id.logout:
                Intent intent4=new Intent(this, LoginActivity.class);
                startActivity(intent4);

            //case R.id.despre:
             //   startActivity(new Intent(this, ListaCarti.class));
             //   return true;


        }

        return super.onOptionsItemSelected(item);
    }




}

