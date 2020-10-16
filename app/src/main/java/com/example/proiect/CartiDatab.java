package com.example.proiect;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "imprumutate")
public class CartiDatab {

    @PrimaryKey(autoGenerate = true)
    private int issn;
    private String titlu;
    private String biblioteca;

    public CartiDatab(int issn, String titlu, String biblioteca) {
        this.issn = issn;
        this.titlu = titlu;
        this.biblioteca = biblioteca;
    }

    public CartiDatab() {
    }

    public int getIssn() {
        return issn;
    }

    public void setIssn(int issn) {
        this.issn = issn;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(String biblioteca) {
        this.biblioteca = biblioteca;
    }
}

