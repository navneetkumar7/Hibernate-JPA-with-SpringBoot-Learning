package com.nt.database.jpahibernateadvance.repository;

import com.nt.database.DemoApplication;
import com.nt.database.jpahibernateadvance.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
        typedQuery.setParameter("id",10001);
        List<Course> resultList = typedQuery.getResultList();
        logger.info("named query:select c from Course c where id'-> {}", resultList);
    }
}