package com.example.proiect;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CartiDAO {
    @Insert
    public void insert(CartiDatab curs);

    @Insert
    public void insert(List<CartiDatab> carti);

    @Query("Select * from imprumutate")
    public List<CartiDatab> getAll();

    @Query("Delete from imprumutate")
    public void deleteAll();

    @Query("Delete from imprumutate where issn = :issn1")
    public void deleteWhere(long issn1);



    @Delete
    public void deleteCV(CartiDatab carti);

}
