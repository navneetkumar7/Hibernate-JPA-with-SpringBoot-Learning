package com.nt.database.jpahibernateadvance.repository;

import com.nt.database.DemoApplication;
import com.nt.database.jpahibernateadvance.entity.Course;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DemoApplication.class)
class CourseRepositoryTest {
    private Logger logger= LoggerFactory.getLogger(CourseRepositoryTest.class);
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void findByIdTest() {
        Course course = courseRepository.findById(10001);
        assertEquals("jpa learning", course.getName());
    }
    @Test
    @DirtiesContext // we don't want unit test to change the data, system will reset the data after test execution
    public void deleteByIdTest() {
        courseRepository.deleteById(10002);
        assertNull(courseRepository.findById(10002));
    }
    @Test
    @DirtiesContext
    public void saveTest() {
        //get course
        Course course = courseRepository.findById(10001);
        assertEquals("jpa learning", course.getName());
        course.setName("jpa and hibernate learning");
        //updating course
        courseRepository.save(course);
        Course updatedCourse = courseRepository.findById(10001);
        // checking updated values
        assertEquals("jpa and hibernate learning", updatedCourse.getName());
    }
    @Test
    @DirtiesContext
    public void moreAboutEMTest() {
        courseRepository.emTracking();
    }


    @ParameterizedTest
    @ValueSource(ints={10003})
    @Transactional
    public void retrieveCourse(int id)
    {
        Course course= courseRepository.findById(id);
        logger.info("fetching course -> {}",course);
        logger.info("fetching reviews from course -> {}",course.getReviews());
    }
}