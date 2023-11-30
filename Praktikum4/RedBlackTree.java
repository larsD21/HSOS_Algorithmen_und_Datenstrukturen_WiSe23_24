package Praktikum4;

public class RedBlackTree {
    private RBTNode nil = new RBTNode(-1, "nil");
    private RBTNode root;
    public RedBlackTree() {
        nil.color = RBTNode.black;
        this.root = nil;
    }
    public void insert(int k, String s) {
        RBTNode z = new RBTNode(k, s);
        z.left = nil;
        z.right = nil;
        RBTNode y = nil;
        RBTNode x = root;

        while (x != nil) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        z.parent = y;
        if (y == nil) {
            root = z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.left = nil;
        z.right = nil;
        z.color = RBTNode.red; // Set color to RED
        rbInsertFixup(z);
    }

    private void leftRotate(RBTNode x) {
        RBTNode y = x.right;
        x.right = y.left;
        if (y.left != nil) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == nil) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(RBTNode y) {
        RBTNode x = y.left;
        y.left = x.right;
        if (x.right != nil) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == nil) {
            root = x;
        } else if (y == y.parent.right) {
            y.parent.right = x;
        } else {
            y.parent.left = x;
        }
        x.right = y;
        y.parent = x;
    }

    private void rbInsertFixup(RBTNode z) {
        while (z.parent != nil && z.parent.color == RBTNode.red) {
            if (z.parent == z.parent.parent.left) {
                RBTNode y = z.parent.parent.right;
                if (y.color == RBTNode.red) {
                    z.parent.color = RBTNode.black;
                    y.color = RBTNode.black;
                    z.parent.parent.color = RBTNode.red;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        leftRotate(z);
                    }
                    z.parent.color = RBTNode.black;
                    z.parent.parent.color = RBTNode.red;
                    rightRotate(z.parent.parent);
                }
            } else {
                RBTNode y = z.parent.parent.left;
                if (y.color == RBTNode.red) {
                    z.parent.color = RBTNode.black;
                    y.color = RBTNode.black;
                    z.parent.parent.color = RBTNode.red;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rightRotate(z);
                    }
                    z.parent.color = RBTNode.black;
                    z.parent.parent.color = RBTNode.red;
                    leftRotate(z.parent.parent);
                }
            }
        }
        root.color = RBTNode.black;
    }

    public String search(int k) {
        if (root == nil) {
            return null;
        } else {
            return search(k, root).val;
        }
    }

    private RBTNode search(int k, RBTNode node) {
        if (node != nil) {
            if (k == node.key) {
                return node;
            } else if (k > node.key) {
                return search(k, node.right);
            } else if (k < node.key) {
                return search(k, node.left);
            }
        }
        return null;
    }

    public int height() {
        return height(root)-1;
    }

    private int height(RBTNode node) {
        if (node == nil) {
            return 0;
        } else {
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);

            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    public boolean checkRB() {
        // root is black
        return checkRB(root) && root.color == RBTNode.black;
    }

    private boolean checkRB(RBTNode node) {
        if (node == nil) {
            // nil is black
            return node.color == RBTNode.black;
        }

        // red not after red
        if (node.color == RBTNode.red) {
            if (node.right.color == RBTNode.red) {
                return false;
            }
            if (node.left.color == RBTNode.red) {
                return false;
            }
        }

        // black count path
        int blackCountLeft = countBlack(node.left);
        int blackCountRight = countBlack(node.right);

        if (blackCountRight != blackCountLeft) {
            System.out.println(blackCountRight + " " + blackCountLeft);
            return false;
        }

        return checkRB(node.left) && checkRB(node.right);
    }

    private int countBlack(RBTNode node) {
        if (node == nil) {
            return 1;
        }

        int countLeft = countBlack(node.left);
        int countRight = countBlack(node.right);

        if (node.color == RBTNode.black) {
            return Math.max(countLeft, countRight) + 1;
        } else {
            return Math.max(countLeft, countRight);
        }
    }

    public void manipulate(){
       boolean isManipulated = false;
       RBTNode node = root.left;
       while (!isManipulated){

           if(node.color == RBTNode.red){
               node.left.color = RBTNode.red;
               isManipulated = true;
           }
           node = node.left;
       }
    }
}
