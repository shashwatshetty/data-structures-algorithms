package redblacktree;

public class TestRBTree {
    public static void main(String args[]){
        RBTree rb = new RBTree();
        int[] input = {4, 2, 7, 1, 8, 3, 10, 9, 5, 6, 12};
        buildRBTree(rb, input);
        System.out.print("Sorting Using Inorder Tree Walk: ");
        System.out.println(rb.toString());
    }

    public static void buildRBTree(RBTree rb, int[] input){
        for(int e : input){
            RBTree.rbInsert(rb, new RBNode(e));
        }
    }
}
