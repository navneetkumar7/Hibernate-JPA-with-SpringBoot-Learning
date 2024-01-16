package com.nt.database.jdbctojpa.jpaHinbernateAdvance.repository;

import com.nt.database.jdbctojpa.DemoApplication;
import com.nt.database.jdbctojpa.jpaHinbernateAdvance.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DemoApplication.class)
class CourseRepositoryTest {
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
}