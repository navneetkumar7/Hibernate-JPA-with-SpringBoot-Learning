package com.nt.database.jpahibernateadvance.entity;

import jakarta.persistence.*;

@Entity
public class Passport {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "number", nullable = false)
    private String number;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    private Student student;

    protected Passport() {

    }

    public Passport(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
