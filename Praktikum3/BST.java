package Praktikum3;

public class BST {
    BSTNode root;

    public BST(){}

    public void insert(int k, String s) {
        if(this.root == null){
            this.root = new BSTNode(k, s);
        } else{
            insert(k, s, this.root);
        }
    }

    private void insert(int k, String s, BSTNode root){
        if(k > root.getKey()){
            if(root.getRight() != null){
                insert(k, s, root.getRight());
            } else{
                root.setRight(new BSTNode(k ,s));
            }
        } else if (k < root.getKey()) {
            if(root.getLeft() != null){
                insert(k, s, root.getLeft());
            } else{
                root.setLeft(new BSTNode(k, s));
            }
        }
    }

    public String search(int k) {
        if(this.root == null){
            return "Tree is empty";
        } else {
            return search(k, root);
        }
    }

    private String search(int k, BSTNode root){
        if(k == root.getKey()){
            return root.getVal();
        } else if (k > root.getKey()) {
            return search(k, root.getRight());
        } else if (k < root.getKey()) {
            return search(k, root.getLeft());
        } else {
            return "Not found";
        }

    }

    public int height() {
        //rekursiv
        return -1;
    }

    public boolean isValidBST() {
        //rekursiv
        return false;
    }

    public void remove(int k) {

    }
}
