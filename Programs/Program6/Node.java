public class Node {
    protected Node left;
    protected Node right;
    protected int data;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node getLeft(){return left;}
    public Node getRight(){return right;}
    public int getData(){return data;}
    public void setLeft(Node node){this.left = node;}
    public void setRight(Node node){this.right = node;}
}
