package C;

public class RedBlackTree {
    private RBTNode nil = new RBTNode(-1, "nil");
    private RBTNode root;
    public RedBlackTree() {} // Konstruktor
    public void insert(int k, String s) {
        RBTNode z = new RBTNode(k , s);
        RBTNode y = nil;
        RBTNode x = this.root;

        if(this.root == null){
            this.root = z;
            z.setColor(RBTNode.black);
            z.setLeft(nil);
            z.setRight(nil);
        } else{
            while (x != nil){
                y = x;
                if(z.getKey() < x.getKey()){
                    x = x.getLeft();
                } else{
                    x = x.getRight();
                }
            }
            z.setParent(y);

            if(y.equals(nil)){
                this.root = z;
            } else if (z.getKey() > y.getKey()) {
                y.setLeft(z);
            } else {
                y.setRight(z);
            }

            z.setLeft(nil);
            z.setRight(nil);
            z.setColor(RBTNode.red);

            RBInsertFixup(z);
        }

    }

    private void RBInsertFixup(RBTNode z){
        while (z.getParent().getColor() == RBTNode.red){
            if(z.getParent().equals(z.getParent().getParent().getLeft())){
                RBTNode y = z.getParent().getParent().getRight();
                if(y.getColor() == RBTNode.red){
                    z.getParent().setColor(RBTNode.black);
                    y.setColor(RBTNode.black);
                    z.getParent().getParent().setColor(RBTNode.red);
                    z = z.getParent().getParent();
                } else {
                    if(z.equals(z.getParent().getRight())){
                        z = z.getParent();
                        leftRotate(z);
                    }
                    z.getParent().setColor(RBTNode.black);
                    z.getParent().getParent().setColor(RBTNode.red);
                    rightRotate(z.getParent().getParent());
                }
            } else {
                RBTNode y = z.getParent().getParent().getLeft();
                if (y.getColor() == RBTNode.red) {
                    z.getParent().setColor(RBTNode.black);
                    y.setColor(RBTNode.black);
                    z.getParent().getParent().setColor(RBTNode.red);
                    z = z.getParent().getParent();
                } else {
                    if (z.equals(z.getParent().getLeft())) {
                        z = z.getParent();
                        rightRotate(z);
                    }
                    z.getParent().setColor(RBTNode.black);
                    z.getParent().getParent().setColor(RBTNode.red);
                    leftRotate(z.getParent().getParent());
                }
            }
        }
        this.root.setColor(RBTNode.black);
    }

    private void leftRotate(RBTNode x){
        if(x.getRight().equals(nil)){
            return;
        }
        RBTNode y = x.getRight();
        x.setRight(y.getLeft());
        if(y.getLeft() != nil){
            y.getLeft().setParent(x);
        }
        y.setParent(x.getParent());
        if(x.getParent().equals(nil)){
            this.root = y;
        } else if (x.equals(x.getParent().getLeft())) {
            x.getParent().setLeft(y);
        } else {
            x.getParent().setRight(y);
        }

        y.setLeft(x);
        x.setParent(y);
    }

    private void rightRotate(RBTNode y) {
        if (y.getLeft().equals(nil)) {
            return;
        }
        RBTNode x = y.getLeft();
        y.setLeft(x.getRight());
        if (x.getRight() != nil) {
            x.getRight().setParent(y);
        }
        x.setParent(y.getParent());
        if (y.getParent().equals(nil)) {
            this.root = x;
        } else if (y.equals(y.getParent().getRight())) {
            y.getParent().setRight(x);
        } else {
            y.getParent().setLeft(x);
        }

        x.setRight(y);
        y.setParent(x);
    }

    public String search(int k) {
        if(root == null){
            return  null;
        } else {
            return search(k, this.root).getVal();
        }
    }

    private RBTNode search(int k, RBTNode node){
        if (node != null) {
            if(k == node.getKey()){
                return node;
            } else if (k > node.getKey()) {
                return search(k, node.getRight());
            } else if (k < node.getKey()) {
                return search(k, node.getLeft());
            }
        }
        return null;
    }

    public int height() {
        return height((this.root));
    }

    private int height(RBTNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = height(node.getLeft());
            int rightHeight = height(node.getRight());

            if(leftHeight>rightHeight){
                return 1 + leftHeight;
            } else{
                return 1 + rightHeight;
            }
        }
    }
    public boolean CheckRB() {
        //root is black
        return CheckRB(this.root) && this.root.getColor() == RBTNode.black;
    }

    private boolean CheckRB(RBTNode node){
        if (node == nil){
            //nil is black
            return node.getColor() == RBTNode.black;
        }

        //red not after red
        if(node.getColor() == RBTNode.red){
            if (node.getRight().getColor()  == RBTNode.red){
                return false;
            }
            if (node.getLeft().getColor() == RBTNode.red){
                return false;
            }
        }

        //black count path
        int blackCountLeft = countBlack(node.getLeft());
        int blackCountRight = countBlack(node.getRight());

        if (blackCountRight != blackCountLeft){
            return false;
        }

        return CheckRB(node.getLeft()) && CheckRB(node.getRight());
    }

    private int countBlack(RBTNode node){
        if(node != nil){
            return 0;
        }

        int countLeft = countBlack(node.getRight());
        int countRight = countBlack(node.getLeft());

        if(node.getColor() == RBTNode.black){
            if(countLeft>countRight){
                return countLeft + 1;
            } else {
                return countRight +1;
            }
        } else {
            return Math.max(countLeft, countRight);
        }
    }
}
