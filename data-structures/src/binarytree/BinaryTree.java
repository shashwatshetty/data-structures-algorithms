package binarytree;

public class BinaryTree {
    private BinaryNode root;

    public BinaryTree(){}

    public BinaryTree(BinaryNode node){
        this.root = node;
    }

    public BinaryNode getRoot() {
        return root;
    }

    public void setRoot(BinaryNode root) {
        this.root = root;
    }
}
