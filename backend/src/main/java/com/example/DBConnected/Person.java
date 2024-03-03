package com.example.DBConnected;

import jakarta.persistence.*;

//example of model representing table and its columns
//table name only with underscore, camelCase will be converted to camel_case

@Entity
@Table(name = "xddddd")
public class Person {

    //private fields, without notation means they are also column names in the table
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;

    private Person() {}

    public Person(String first_name, String last_name, String email, String gender){
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }
}
