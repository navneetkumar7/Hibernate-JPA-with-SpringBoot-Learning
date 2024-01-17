package com.nt.database.jpahibernateadvance.repository;

import com.nt.database.jpahibernateadvance.entity.Course;
import com.nt.database.jpahibernateadvance.entity.Review;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CourseRepository {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager em;

    public Course findById(int id) {
        return em.find(Course.class, id);
    }

    public void deleteById(int id) {
        Course course = findById(id);
        em.remove(course);
    }

    public void save(Course course) {
        if (course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }
    }

    public void emTracking() {
        Course course = new Course("web services learning");
        em.persist(course);
        //updating course name to see it behaviour will it be updated in db as well : Yes : reason: @Transactional
        course.setName("web services implementation");
    }

    public void emNonTracking() {
        Course course1 = new Course("html learning");
        em.persist(course1);
        Course course2 = new Course("java script learning");
        em.persist(course2);
        em.flush(); // to save the state till this point to db

        em.detach(course1);// detaching em(persistenceContext) from tracking particular object
        em.clear(); // detaching all the objects tracking under transactional context

        course1.setName("html implementation");
        course2.setName("java script implementation");
        em.flush();
    }

    // refresh method pulls the state from db for the particular object
    public void emRefreshMethod() {
        Course course1 = new Course("html learning");
        em.persist(course1);
        Course course2 = new Course("java script learning");
        em.persist(course2);
        em.flush(); // to save the state till this point to db

        // update name
        course1.setName("html implementation");
        course2.setName("java script implementation");

        em.refresh(course1); // it will pull the course1 state from db , so updated name won't be saved for course1
        em.flush();
    }

    public void addReviewsForCourse(int id, List<Review> reviewList){
        Course course= findById(id);

        for(Review review: reviewList)
        {
            //setting the relationships
            //course.addReview(review1);
            review.setCourse(course); // setting the relation from the owning side would be sufficient
            em.persist(review);
        }
    }

    public  void getCourseAndStudent(int courseId)
    {
        Course course=em.find(Course.class,courseId);
        logger.info("saved course-> {} associated student-> {}", course, course.getStudents());
    }
}
