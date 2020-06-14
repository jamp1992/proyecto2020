package com.example.proyecto.back.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = Person.TABLE_NAME)
public class Person {
    public static final String TABLE_NAME= "employee";
    public static final String COLUMN_FIRSTNAME= "firstName";
    public static final String COLUMN_LASTNAME= "lastName";
    public static final String COLUMN_BIRTH= "birth";
    private int id;
    private String firstName;
    private String lastName;
    private Date birth;

    public Person() {

    }

    public Person(String firstName, String lastName, Date birth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = COLUMN_FIRSTNAME, nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = COLUMN_LASTNAME, nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = COLUMN_BIRTH, nullable = false)
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + birth
                + "]";
    }
}
