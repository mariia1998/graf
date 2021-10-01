package m1graf2021;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node>{
    private String name;
    private int id;


    /*
     * Constructor who create a node with an id without a name
     * @param id the id of one node
     */
    public Node(int id) {
        this.id = id;
    }

    /*
     * Constructor who create a node with a name and an id
     * @param name the name of one node
     * @param id the id of one node
     */
    public Node(int id, String name) {
        this(id);
        this.name = name;
    }


    @Override
    public int compareTo(Node other) {
        if(other == null) {
            throw new NullPointerException("The node doesn't exist");
        }
        return this.id - other.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() { return this.name.hashCode(); }

    @Override
    public String toString() { return Integer.toString(id);}

    @Override
    public boolean equals(Object o) {
        if(o == null) {
            return false;
        }
        if(o.getClass() != this.getClass()) {
            return false;
        }

        final Node other = (Node)o;
        if(this.id != other.id) {
            return false;
        }

        return true;

    }
}
