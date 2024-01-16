package com.nt.database.jdbctojpa.jpaHinbernateAdvance.repository;

import com.nt.database.jdbctojpa.DemoApplication;
import com.nt.database.jdbctojpa.jpaHinbernateAdvance.entity.Course;
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

@SpringBootTest(classes = DemoApplication.class)
class NativeQueriesTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EntityManager em;

    @Test
    public void nativeQueryBasicTest() {
        Query query = em.createNativeQuery("select * from Course", Course.class);
        List resultList = query.getResultList();
        logger.info("select * from Course-> {}", resultList);
    }



    @Test
    public void nativeQueryWithParameterTest() {
        Query query = em.createNativeQuery("select * from Course c where id = ?", Course.class);
        query.setParameter(1,10001);
        List<Course> resultList = query.getResultList();
        logger.info("select * from Course c where id = ? ->{}", resultList);
    }

    @Test
    public void nativeQueryWithNamedParameterTest() {
        Query query = em.createNativeQuery("select * from Course c where id = :id", Course.class);
        query.setParameter("id",10001);
        List<Course> resultList = query.getResultList();
        logger.info("select * from Course c where id = :id ->{}", resultList);
    }

    @Test
    @Transactional
    public void nativeQueryWithAllUpdateTest() {
        Query query = em.createNativeQuery("update  Course set last_updated_date='2024-01-16 13:47:09.828463'", Course.class);
        int updatedRows = query.executeUpdate();
        logger.info("        Query query = em.createNativeQuery(\"update  Course set lat_updated_date='2024-01-16 13:47:09.828463'\", Course.class);\n ->{}", updatedRows);
    }
}