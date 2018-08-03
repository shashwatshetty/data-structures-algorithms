package binarytree;

public class TestBinaryTree {
    public static void main(String args[]){
        TreeOps op = new TreeOps();
        int[] n = {3, 4, 6, 0, 1, 5, 2};
        BinaryTree t = op.buildBinaryTree(n);
        op.inOrderTraversal(t);
        System.out.println();
        op.preOrderTraversal(t);
        System.out.println();
        op.postOrderTraversal(t);
    }
}
