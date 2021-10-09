package m1graf2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {

    @Test
    void setWeight() {
    }

    @Test
    void getWeight() {
    }

    @Test
    void setTo() {
        //From the constructor
        Edge edge = new Edge(1,2);


        int getTo = edge.getTo();
        assertEquals(2, getTo);
        assertNotEquals(1, getTo);


        //From setTo method
        edge.setTo(3);
        getTo = edge.getTo();;
        assertNotEquals(2, getTo);
        assertEquals(3, getTo);


    }

    @Test
    void getFrom() {
        //From the constructor
        Edge edge = new Edge(1,2);


        int getFrom = edge.getFrom();
        assertEquals(1, getFrom);
        assertNotEquals(2, getFrom);


        //From setFrom method
        edge.setFrom(2);
        getFrom = edge.getFrom();
        assertNotEquals(1, getFrom);
        assertEquals(2, getFrom);
    }


    @Test
    void prettyPrint() {
        Edge edge = new Edge(1,2);
        System.out.println(edge);

    }

    @Test
    void compareTo() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }
}