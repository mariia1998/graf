package m1graf2021;

//import org.junit.Test;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class NodeTest {

    @Test
    void compareTo() {
        Node node = new Node(1);
        Node nodeGreater = new Node(2);
        assertTrue(0 > node.compareTo(nodeGreater));

        Node nodeEqual = new Node(1);
        assertEquals(0, node.compareTo(nodeEqual));

        Node nodeSmaller = new Node(0);
        assertTrue(0 < node.compareTo(nodeSmaller));

        Node nullPointer = null;

        assertThrows(NullPointerException.class,
                ()->{
                    int res = node.compareTo(nullPointer);
                });
    }


    @Test
    void testEquals() {
        Node node = new Node(1);
        Node nullPointerNode = null;
        Node sameValueNode = new Node(1);
        Node differentValueNode = new Node(2);

        assertEquals(node, sameValueNode);
        assertNotEquals(node, differentValueNode);
        assertNotEquals(node, nullPointerNode);

    }

}