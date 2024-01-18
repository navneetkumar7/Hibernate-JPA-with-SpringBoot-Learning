package com.nt.database.jpahibernateadvance.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
@Entity
public class FullTimeEmployee extends Employee {
    private BigDecimal salary;
    protected FullTimeEmployee() {

    }

    public FullTimeEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "salary=" + salary +
                '}';
    }
}
