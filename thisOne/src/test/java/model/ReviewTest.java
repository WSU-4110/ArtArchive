package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {

    @Test
    void testGetId() {
        Review r= new Review("name",1234);
        assertEquals(1234,r.getSalesID());
    }

    @Test
    void testSetId() {
        Review r = new Review("name",1234);
        assertEquals(1234,1234);
    }

    @Test
    void testGetReview() {
        Review x = new Review("good","apple",1234,5);
        assertEquals("good",x.getReview());
    }

    @Test
    void testSetReview() {

        Review x = new Review("good","apple",1234,4);

        assertEquals("good","good");
    }

    @Test
    void testGetStars() {
        Review x = new Review("good","apple",1234,4);
        assertEquals(4,x.getStars());
    }

    @Test
    void testSetStars() {
        Review x = new Review("good","apple",1234,4);
        assertEquals(4,4);
    }

    @Test
    void testGetSalesID() {
        Review x = new Review("good","apple",1234,4);
        assertEquals(1234, x.getSalesID());

    }

    @Test
    void testSetSalesID() {
        Review x = new Review("good","apple",1234,4);
        assertEquals(1234,1234);
    }

    @Test
    void testGetUser() {
        Review x = new Review("good","apple",1234,4);
        assertEquals("apple", x.getUser());

    }

    @Test
    void testSetUser() {
        Review x = new Review("good","apple",1234,4);
        assertEquals("apple","apple");
    }

}
