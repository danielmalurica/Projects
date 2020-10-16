package com.example.proiect;

import android.widget.EditText;
import android.widget.Spinner;

public class Book {
    private String titlu;
    private String autor;
    private String categorie;
    private int issn;

    public Book() {
    }

    public Book(String titlu, String autor, String categorie, int issn) {
        this.titlu = titlu;
        this.autor = autor;
        this.categorie = categorie;
        this.issn = issn;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getIssn() {
        return issn;
    }

    public void setIssn(int issn) {
        this.issn = issn;
    }
}