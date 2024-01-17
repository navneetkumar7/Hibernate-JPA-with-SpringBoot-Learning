package com.nt.database.jpahibernateadvance.repository;

import com.nt.database.jpahibernateadvance.entity.Course;
import com.nt.database.jpahibernateadvance.entity.Review;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ReviewRepository {
    @Autowired
    EntityManager em;

    public Review findById(int id) {
        return em.find(Review.class, id);
    }

    public void deleteById(int id) {
        Review review = findById(id);
        em.remove(review);
    }


}
