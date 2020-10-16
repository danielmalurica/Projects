package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Arrays;
import java.util.List;

public class adaugaImprumutate extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_citite);

        CartiDatab carti1=new CartiDatab(1234, "Cele sapte surori", "Biblioteca Nationala");
        CartiDatab carti2=new CartiDatab(1367, "Departe de lumea dezlantuita", "Biblioteca Metropolitana");
        CartiDatab carti3=new CartiDatab(1844, "Pacatele noptii", "Biblioteca Adevarul");

        final CartiDatabase cartiDBs=CartiDatabase.getInstance(this);
        cartiDBs.getCartiDao().deleteAll();

        List<CartiDatab> carti= Arrays.asList(carti1, carti2, carti3);

        cartiDBs.getCartiDao().insert(carti);




        final ListView listView = findViewById(R.id.listView1);

        final ArrayAdapter<CartiDatab> adaptor = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cartiDBs.getCartiDao().getAll());
        listView.setAdapter(adaptor);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                List<CartiDatab> listal = cartiDBs.getCartiDao().getAll();
                CartiDatab cd1 = listal.get(position);
                cartiDBs.getCartiDao().deleteCV(cd1);

                ArrayAdapter<CartiDatab> adaptor1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, cartiDBs.getCartiDao().getAll());
                listView.setAdapter(adaptor1);
                return true;
            }
        });



    }
}
