package C;

public class RBTNode {
    public static final boolean black=false;
    public static final boolean red=true;
    private int key;
    private String val;
    private Boolean color;
    private RBTNode left, right, parent;
    public RBTNode(int k, String s) {
        this.key = k;
        this.val = s;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public Boolean getColor() {
        return color;
    }

    public void setColor(Boolean color) {
        this.color = color;
    }

    public RBTNode getLeft() {
        return left;
    }

    public void setLeft(RBTNode left) {
        this.left = left;
    }

    public RBTNode getRight() {
        return right;
    }

    public void setRight(RBTNode right) {
        this.right = right;
    }

    public RBTNode getParent() {
        return parent;
    }

    public void setParent(RBTNode parent) {
        this.parent = parent;
    }
}
