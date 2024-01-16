package com.nt.database.jdbctojpa.jpa.entity;

import jakarta.persistence.*;

import java.util.Date;
//@Entity
@NamedQuery(name="find_all_persons", query="select p from Person p")
@Table(name="person") // not needed as person matches with the name of the entity class
public class Person {
    @Id // indicates this is primary key
    @GeneratedValue //hibernate will take care of the id generation, hibernate creates sequence in db and
    // uses it for id generation.
    private int id;
    @Column(name="name") // this is not needed here as column name is same as object field name
    private String name;
    private String location;
    private Date birthDate;

    public Person(){

    }
    public Person(int id, String name, String location, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }
    public Person(String name, String location, Date birthDate) {
        super();
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
