package binarytree;

public class TreeOps {

    // Given an array of non negative numbers.
    // Returns a BinaryTree with the numbers as node values.
    public BinaryTree buildBinaryTree(int[] nums){
        BinaryTree t = new BinaryTree();
        for(int n : nums){
            BinaryNode current = new BinaryNode(n);
            if(t.getRoot() == null){
                t.setRoot(current);
            }else{
                BinaryNode x = t.getRoot();
                BinaryNode previous = null;
                while( x != null){
                    previous = x;
                    if(x.getValue() > current.getValue()){
                        x = x.getLeft();
                    }else{
                        x = x.getRight();
                    }
                }
                if(previous.getValue() > current.getValue()){
                    previous.setLeft(current);
                }else{
                    previous.setRight(current);
                }
            }
        }
        return t;
    }

    // Given a BinaryTree.
    // Effect prints the node values of the given tree using
    //    in-order traversal.
    public void inOrderTraversal(BinaryTree t){
        if(t.getRoot() == null){
            return;
        }else{
            BinaryNode r = t.getRoot();
            inOrderTraversal(new BinaryTree(r.getLeft()));
            System.out.print(r.getValue()+" ");
            inOrderTraversal(new BinaryTree(r.getRight()));
        }
    }

    // Given a BinaryTree.
    // Effect prints the node values of the given tree using
    //    pre-order traversal.
    public void preOrderTraversal(BinaryTree t){
        if(t.getRoot() == null){
            return;
        }else{
            BinaryNode r = t.getRoot();
            System.out.print(r.getValue()+" ");
            preOrderTraversal(new BinaryTree(r.getLeft()));
            preOrderTraversal(new BinaryTree(r.getRight()));
        }
    }

    // Given a BinaryTree.
    // Effect prints the node values of the given tree using
    //    post-order traversal.
    public void postOrderTraversal(BinaryTree t){
        if(t.getRoot() == null){
            return;
        }else{
            BinaryNode r = t.getRoot();
            postOrderTraversal(new BinaryTree(r.getLeft()));
            postOrderTraversal(new BinaryTree(r.getRight()));
            System.out.print(r.getValue()+" ");
        }
    }
}
