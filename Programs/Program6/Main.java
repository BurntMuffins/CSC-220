public class Main {
    public static void main(String[] args) {
        BST tree = new BST();

        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        tree.insert(14);
        tree.insert(20);

        Vis.runOnWindows = true;

        Vis.test(tree);
    }
}