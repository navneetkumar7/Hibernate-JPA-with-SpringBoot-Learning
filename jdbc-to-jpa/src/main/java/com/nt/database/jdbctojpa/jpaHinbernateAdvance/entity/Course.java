package com.nt.database.jdbctojpa.jpaHinbernateAdvance.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Course") // if entity name is different from the db table, e,g coursedetails--> course_details table
@NamedQueries(value={
        @NamedQuery(name="query_get_all_courses",query="Select c from Course c"),
        @NamedQuery(name="query_get_all_courses_with_learning",query="select c from Course c where name like  '%learning'"),
        @NamedQuery(name="query_get_course_with_id",query="select c from Course c where id= :id")
})

public class Course {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;
    @CreationTimestamp
    private LocalDateTime createdDate;
    protected Course() {

    }

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
