package redblacktree;
/*
Implements a Red Black Tree.
 */

public class RBTree{
    private RBNode root;                                // root of the tree
    private int length;                                 // no. of elements in the tree
    private final static RBNode NIL = new RBNode();     // NIL sentinel
    private final static String BLACK = "BLACK";        // Color value for Black nodes
    private final static String RED = "RED";            // Color value for Red nodes

    // Constructor

    public RBTree(){
        this.root = NIL;    // initialises root with sentinel
        length = 0;         // starting length of an empty tree
    }

    // Returns the root of this tree.

    public RBNode getRoot() {
        return root;
    }

    // Given a node
    // Sets the new root node for this tree.

    public void setRoot(RBNode root) {
        this.root = root;
    }

    // Returns the length of this tree.

    public int getLength() {
        return length;
    }

    // Given an integer value
    // Sets the new length of this tree

    public void setLength(int length) {
        this.length = length;
    }

    // Given a Tree and a Node z
    // Effect: Inserts the Node z into the RBT without red-black-property being violated
    // Precondition T should be a complete RB Tree, which satisfies the red-black-property

    public static void rbInsert(RBTree T, RBNode z){
        RBNode y = NIL;                         // parent pointer
        RBNode x = T.getRoot();                 // start from root
        while(!x.equals(NIL)){                  // traverse till NIL sentinel is reached
            y = x;                              // store the parent
            if(z.getKey() < x.getKey()){        // if new node key is less than current node key
                x = x.getLeft();
            }else{
                x = x.getRight();
            }
        }
        z.setP(y);                              // assign new node's parent
        if(y.equals(NIL)){                      // if tree has no element
            T.setRoot(z);                       // new node is the new root
        }else if(z.getKey() < y.getKey()){      // else assign left child of parent
            y.setLeft(z);
        }else{                                  // or right child of parent
            y.setRight(z);
        }
        z.setLeft(NIL);                         // assign left child of new node
        z.setRight(NIL);                        // assign right child of new node
        z.setColor(RED);                        // set color as red
        rbInsertFixup(T, z);                    // call procedure to fix the red-black-property
    }

    // Given a Tree and a Node z
    // Effect: Performs rotations on the nodes of the tree to make it compliant
    //         with the red-black-property
    // Precondition: Given tree violates one of two red-black-property
    //                  1. root is red node
    //                  2. red node has a red node as a child.
    //               Node z must already be a part of T.

    public static void rbInsertFixup(RBTree T, RBNode z){
        while(z.getP().getColor().equals(RED)){                 // till z has a red node parent
            if(z.getP().equals(z.getP().getP().getLeft())){     // z's parent is the left child
                RBNode y = z.getP().getP().getRight();          // pointer to z's uncle
                if(y.getColor().equals(RED)){                   // if z's uncle is red
                    z.getP().setColor(BLACK);                   // make z's parent black
                    y.setColor(BLACK);                          // make z's uncle black
                    z.getP().getP().setColor(RED);              // make z's grandparent red
                    z = z.getP().getP();                        // check property for grandparent
                }else if(z.equals(z.getP().getRight())){        // if z's uncle is black
                    z = z.getP();
                    leftRotate(T, z);                           // left rotate on z's parent if right child
                }else{
                    z.getP().setColor(BLACK);
                    z.getP().getP().setColor(RED);
                    rightRotate(T, z.getP().getP());            // right rotate on z's parent if left child
                }
            }else{
                RBNode y = z.getP().getP().getLeft();           // pointer to z's uncle
                if(y.getColor().equals(RED)){                   // if z's uncle is red
                    z.getP().setColor(BLACK);                   // make z's parent black
                    y.setColor(BLACK);                          // make z's uncle black
                    z.getP().getP().setColor(RED);              // make z's grandparent red
                    z = z.getP().getP();                        // check property for grandparent
                }else if(z.equals(z.getP().getLeft())){         // if z's uncle is black
                    z = z.getP();
                    rightRotate(T, z);                          // right rotate on z's parent if left child
                }else{
                    z.getP().setColor(BLACK);
                    z.getP().getP().setColor(RED);
                    leftRotate(T, z.getP().getP());             // left rotate on z's parent if right child
                }
            }
        }
        T.getRoot().setColor(BLACK);                            // make root black
    }

    // Given a tree and a Node x
    // Effect: rotates the tree towards the left at given node
    // Precondition: x.left is not NIL

    public static void leftRotate(RBTree T, RBNode x){
        RBNode y = x.getRight();                    // pointer to right child
        x.setRight(y.getLeft());
        if(!y.getLeft().equals(NIL)){
            y.getLeft().setP(x);
        }
        y.setP(x.getP());                           // swap parents
        if(x.getP().equals(NIL)){                   // set root if first element
            T.setRoot(y);
        }else if(x.equals(x.getP().getLeft())){     // if left, then left child
            x.getP().setLeft(y);
        }else{                                      // else right child
            x.getP().setRight(y);
        }
        y.setLeft(x);
        x.setP(y);
    }

    // Given a tree and a Node x
    // Effect: rotates the tree towards the right at given node
    // Precondition: x.left is not NIL

    public static void rightRotate(RBTree T, RBNode x){
        RBNode y = x.getLeft();                       // pointer to the left child
        x.setLeft(y.getRight());
        if(!y.getRight().equals(NIL)){
            y.getRight().setP(x);
        }
        y.setP(x.getP());                           // swap parents
        if(x.getP().equals(NIL)){                   // set root if first element
            T.setRoot(y);
        }else if(x.equals(x.getP().getLeft())){     // if left, then left child
            x.getP().setLeft(y);
        }else{
            x.getP().setRight(y);                   // else right child
        }
        y.setRight(x);
        x.setP(y);
    }

    // Returns the string representation of the RBTree in a sorted order.

    @Override
    public String toString() {
        String nums = inOrderTreeWalk(this.getRoot());
        String[] sort = nums.split(" ");
        String res = "{";
        String add = ",";
        for(int i = 0; i < sort.length; i++){
            if(i == sort.length - 1)
                add = "}";
            res = res + sort[i] + add;
        }
        return res;
    }

    // Given a Node x
    // Returns a String values of the element keys in the Tree in a sorted order

    public static String inOrderTreeWalk(RBNode x){
        if(!x.equals(NIL)){
            return inOrderTreeWalk(x.getLeft()) +
                    x.getKey().toString() +" "+
                    inOrderTreeWalk(x.getRight());
        }
        return "";
    }
}
