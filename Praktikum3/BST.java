package Praktikum3;

public class BST {
    BSTNode root;

    public BST(){}

    public void insert(int k, String s) {
        if(root == null){
            this.root = new BSTNode(k, s);
        } else{
            insert(k, s, this.root);
        }
    }

    private BSTNode insert(int k, String s, BSTNode node){
        if(node == null){
            node = new BSTNode(k, s);
            return node;
        }
        if(k > node.getKey()){
                node.setRight(insert(k ,s, node.getRight()));
                node.getRight().setParent(node);
        } else if (k < node.getKey()) {
            node.setLeft(insert(k, s, node.getLeft()));
            node.getLeft().setParent(node);
        }
        return node;
    }

    public String search(int k) {
        if(this.root == null){
            return "Tree is empty";
        } else {
            try{
                return search(k, root).getVal();

            } catch(NullPointerException e){
                return "Not found";
            }
        }
    }

    private BSTNode search(int k, BSTNode node){
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
        return height(this.root);
    }

    private int height(BSTNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = height(node.getLeft());
            int rightHeight = height(node.getRight());

            return 1 + Math.max(leftHeight, rightHeight);
        }
    }


    public boolean isValidBST() {
        return isValidBST(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    //https://www.enjoyalgorithms.com/blog/validate-binary-search-tree
    private boolean isValidBST(BSTNode node, int min, int max){
        if(node==null){
            return true;
        }

        if(node.getKey() < min || node.getKey() > max){
            return false;
        }

        boolean left = isValidBST(node.getLeft(), min, node.getKey()-1);
        boolean right = isValidBST(node.getRight(), node.getKey()+1, max);

        return left && right;

    }

    public void remove(int key) {
        removeNode(this.root, key);
    }

    private BSTNode removeNode(BSTNode node, int key) {
        if (node == null) {
            return node;
        }

        if (key < node.getKey()) {
            node.setLeft(removeNode(node.getLeft(), key));
        } else if (key > node.getKey()) {
            node.setRight(removeNode(node.getRight(), key));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            BSTNode minRight = treeMinimum(node.getRight());
            node.setKey(minRight.getKey());
            node.setVal(minRight.getVal());
            node.setRight(removeNode(node.getRight(), minRight.getKey()));
        }
        return node;
    }


    //Introduction to Algorithms 3rd Edition; Cormen, Leiserson, Rivest, Stein
    private BSTNode treeMinimum(BSTNode x){
        while (x.getLeft() != null){
            x = x.getLeft();
        }
        return x;
    }

    public void manipulateValid(){
        BSTNode node = treeMinimum(this.root).getParent();
        if(node.getLeft() != null){
            node.getLeft().setKey(this.root.getKey()+1);

        }

        if(node.getRight() != null){
            node.getRight().setKey(this.root.getKey()+3);

        }

        node.setKey(this.root.getKey()+2);
    }

}
