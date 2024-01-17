package com.nt.database.jpahibernateadvance.repository;

import com.nt.database.DemoApplication;
import com.nt.database.jpahibernateadvance.entity.Review;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DemoApplication.class)
class ReviewRepositoryTest {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ReviewRepository reviewRepository;
    @Test
    @Transactional
    void retrieveReview() {
        Review review= reviewRepository.findById(50001);
        logger.info("retrieving review->{}", review);
        logger.info("retrieving associated course from review->{}", review.getCourse());

    }
}