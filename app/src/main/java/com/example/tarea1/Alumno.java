package com.example.tarea1;

import android.app.Activity;
import android.widget.Toast;

public class Alumno extends Activity {

    private String name, scholarship, gender, book, phone, sport;

    public Alumno(String name, String scholarship, String gender, String book, String phone, String sport){
        this.name = name;
        this.scholarship = scholarship;
        this.gender = gender;
        this.book = book;
        this.phone = phone;
        this.sport = sport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScholarship(String scholarship) {
        this.scholarship = scholarship;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString(){
        return ("Nombre: " + this.name + "\nTelefono: " + this.phone + "\nEscolaridad: "
                + this.scholarship + "\nGénero: " + this.gender + "\nLibro Favorito: "
                + this.book + "\nPractica deporte: " + this.sport);


    }


}
