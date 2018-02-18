package redblacktree;
/*
Implements the structure of the nodes that are part of a Red Black tree.
 */

public class RBNode {
    private RBNode p;             // parent node
    private RBNode left;          // left child node
    private RBNode right;         // right child node
    private String color;       // color of the node
    private Integer key;        // key of the node

    // constructor to initialise NIL sentinel

    public RBNode(){
        this.color = "BLACK";
        this.p = null;
        this.left = null;
        this. right = null;
        this.key = null;
    }

    // constructor to initialise element node

    public RBNode(Integer key){
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RBNode node = (RBNode) o;
        return this.key == ((RBNode) o).key;
    }

    @Override
    public int hashCode() {
        return this.color.hashCode() +
                this.key.hashCode();
    }

    // Returns this node's parent

    public RBNode getP() {
        return p;
    }

    // Given a Node.
    // Sets this node's parent

    public void setP(RBNode p) {
        this.p = p;
    }

    // Returns this node's left child

    public RBNode getLeft() {
        return left;

    }

    // Returns this node's right child

    public RBNode getRight() {
        return right;
    }

    // Returns this node's color

    public String getColor() {
        return color;
    }

    // Returns this node's key

    public Integer getKey() {
        return key;
    }

    // Given a Node.
    // Sets this node's left child

    public void setLeft(RBNode left) {
        this.left = left;
    }

    // Given a Node.
    // Sets this node's right child

    public void setRight(RBNode right) {
        this.right = right;
    }

    // Given a String.
    // Sets this node's color

    public void setColor(String color) {
        this.color = color;
    }
}
