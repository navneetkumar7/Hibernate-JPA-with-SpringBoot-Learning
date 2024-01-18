package com.nt.database.jpahibernateadvance.repository;

import com.nt.database.DemoApplication;
import com.nt.database.jpahibernateadvance.entity.Course;
import com.nt.database.jpahibernateadvance.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = DemoApplication.class)
class JPQLTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EntityManager em;

    @Test
    public void jpqlBasicQueryTest() {
        Query query = em.createQuery("select c from Course c");
        List resultList = query.getResultList();
        logger.info("select c from Course c-> {}", resultList);
    }

    @Test
    public void jpqlTypedQueryTest() {
        TypedQuery<Course> typedQuery = em.createQuery("select c from Course c", Course.class);
        List<Course> resultList = typedQuery.getResultList();
        logger.info("select c from Course c-> {}", resultList);
    }

    @Test
    public void jpqlBasicNamedQueryTest() {
        Query query = em.createNamedQuery("query_get_all_courses");
        List resultList = query.getResultList();
        logger.info("select c from Course c-> {}", resultList);
    }

    @Test
    public void jpqlTypedNamedQueryTest() {
        TypedQuery<Course> typedQuery = em.createNamedQuery("query_get_all_courses", Course.class);
        List<Course> resultList = typedQuery.getResultList();
        logger.info("select c from Course c-> {}", resultList);
    }

    @Test
    public void jpqlWithWhereTest() {
        TypedQuery<Course> typedQuery = em.createQuery("select c from Course c where name like  '%learning'", Course.class);
        List<Course> resultList = typedQuery.getResultList();
        logger.info("select c from Course c where name like '%learning'-> {}", resultList);
    }

    @Test
    public void jpqlWithNamedWhereTest() {
        TypedQuery<Course> typedQuery = em.createNamedQuery("query_get_all_courses_with_learning", Course.class);
        List<Course> resultList = typedQuery.getResultList();
        logger.info("named query:select c from Course c where name like '%learning'-> {}", resultList);
    }


    @Test
    public void jpqlWithNamedQueryIdTest() {
        TypedQuery<Course> typedQuery = em.createNamedQuery("query_get_course_with_id", Course.class);
        typedQuery.setParameter("id", 10001);
        List<Course> resultList = typedQuery.getResultList();
        logger.info("named query:select c from Course c where id'-> {}", resultList);
    }

    @Test
    public void jpqlCourseWithoutStudentsTest() {
        TypedQuery<Course> typedQuery = em.createQuery("select c from Course c where c.students is empty", Course.class);
        List<Course> resultList = typedQuery.getResultList();
        logger.info("courses without students'-> {}", resultList);
    }

    @Test
    public void jpqlCourseWithMoreThan2StudentsTest() {
        TypedQuery<Course> typedQuery = em.createQuery("select c from Course c where size(c.students) >=2", Course.class);
        List<Course> resultList = typedQuery.getResultList();
        logger.info("courses >=2 students'-> {}", resultList);
    }

    @Test
    public void jpqlCourseOrderByNoOfStudentsTest() {
        TypedQuery<Course> typedQuery = em.createQuery("select c from Course c order by size(c.students)", Course.class);
        List<Course> resultList = typedQuery.getResultList();
        logger.info("courses ordered by no of students'-> {}", resultList);
    }

    @Test
    public void jpqlCourseDescOrderByNoOfStudentsTest() {
        TypedQuery<Course> typedQuery = em.createQuery("select c from Course c order by size(c.students) desc", Course.class);
        List<Course> resultList = typedQuery.getResultList();
        logger.info("courses DESC ordered by no of students'-> {}", resultList);
    }

    @Test
    @Transactional
    void jpqlStudentsWithPassportInCertainPatternTest() {
        TypedQuery<Student> typedQuery = em.createQuery("select s from Student s where s.passport.number like  '%98%'", Student.class);
        List<Student> resultList = typedQuery.getResultList();
        logger.info("Student s where s.passport.number like  '%98%'-> {}", resultList);
    }

    //JOIN => select c, s from Course c JOIN c.students s
    //LEFT JOIN => select c, s from Course c LEFT JOIN c.students s
    //CROSS JOIN => select c, s from Course c, Student s
    @Test
    @Transactional
    public void join() {
        Query query = em.createQuery("select c, s from Course c JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("results size -{}", resultList.size());
        for (Object[] result : resultList) {
            logger.info("course -{} Student-{}",
                    result[0],
                    result[1]);
        }
    }

    @Test
    @Transactional
    public void leftJoin() {
        Query query = em.createQuery("select c, s from Course c LEFT JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("results size -{}", resultList.size());
        for (Object[] result : resultList) {
            logger.info("course -{} Student-{}",
                    result[0],
                    result[1]);
        }
    }

    @Test
    @Transactional
    public void crossJoin() {
        Query query = em.createQuery("select c, s from Course c CROSS JOIN Student s");
        List<Object[]> resultList = query.getResultList();
        logger.info("results size -{}", resultList.size());
        for (Object[] result : resultList) {
            logger.info("course -{} Student-{}",
                    result[0],
                    result[1]);
        }
    }
}