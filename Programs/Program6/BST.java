public class BST {
    public Node root;
    
    public BST(){
        this.root = null;
    }

    /**
     * Inserts a value into the binary tree
     * @param value The value to be inserted
     */
    public void insert(int value){
        // Create the Node to be added
        Node node = new Node(value);
        // If the root is null then set the root to the new node
        if (root == null){
            root = node;
            return;
        }
        Node cur = root;
        while(true){
            // If the new value is less than the current value
            if (value < cur.getData()){
                // If the left is null then set the left to the new node and return
                if (cur.getLeft() == null){
                    cur.setLeft(node);
                    break;
                } 
                // Else set the current to the current's left node
                else {
                    cur = cur.getLeft();
                }
            }
            // If the new vlaue is greater than the current value
            else if(value > cur.getData()){
                // If the right is null then set the right to the new node and return
                if (cur.getRight() == null){
                    cur.setRight(node);
                    break;
                } 
                // Else set the current to tho current's right node
                else {
                    cur = cur.getRight();
                }
            }
        }
    }

    /**
     * 
     * @param value The value to search for
     * @return boolean If the value was found or not
     */
    public boolean search(int value){
        Node cur = root;
        while(cur != null){
            // If current data == value return true
            if(cur.getData() == value){
                return true;
            } 
            // Else if the value is less than current data go to the left of the current Node
            else if (value < cur.getData()){
                cur = cur.getLeft();
            } 
            // Else, the value is greater than the current Node so go to the right
            else {
                cur = cur.getRight();
            }
        }
        // Return false if the value is not found
        return false;
    }

    /**
     * Removes the given value from the tree
     * @param value the value to be removed
     */
    public void delete(int value){
        // First check to make sure the value we are deleting exists
        if(!search(value)){return;}
        // Walk to the node to be deleted
        Node cur = root;
        Node prev = null;

        while(cur.getData() != value){
            if (value < cur.getData()){
                prev = cur;
                cur = cur.getLeft();
            } else {
                prev = cur;
                cur = cur.getRight();
            }
        }

        // Check the case of the node being deleted
        // If left and right children are null then case 0
        if (cur.getLeft() == null && cur.getRight() == null){
            case0(prev, cur, value);
            return;
        } 
        // If the current only has 1 child then case 1
        else if(cur.getLeft() == null ^ cur.getRight() == null){
            case1(prev, cur, value);
            return;
        } 
        // else the current has two children so case 2
        else {
            case2(prev, cur, value);
            return;
        }
    }

    /**
     * Returns the minimum value in the tree
     * @return int The smallest value in the tree
     */
    public int min(){
        // If the root is null then return -1
        if (root == null){return -1;}
        Node cur = root;
        // Go as far left as possible 
        while(cur.getLeft() != null){
            cur = cur.getLeft();
        }
        // return the leftmost value
        return cur.getData();
    }

    /**
     * Returns the largest value in the tree
     * @return int The largest value in the tree
     */
    public int max(){
        // if the root is null return -1
        if(root == null){return -1;}
        Node cur = root;
        // go as far right as possible
        while(cur.getRight() != null){
            cur = cur.getRight();
        }
        // return the rightmost value 
        return cur.getData();
    }

    /**
     * Returns a String of all values in the array in numerical order
     * @return String The values of the tree in numerical order
     */
    public String inorder(){
        return inorderRecursive(root);
    }

    /**
     * Returns a String of the values in preorder
     * @return String The values in preorder
     */
    public String preorder(){
        return preorderRecursive(root);
    }

    /**
     * Returns a string of the values in postorder
     * @return String The values in postorder
     */
    public String postorder(){
        return postorderRecursive(root);
    }

    // Private methods
    private String inorderRecursive(Node cur){
        // if the current node is null then return an empty string
        if(cur == null){
            return "";
        }

        String left = inorderRecursive(cur.getLeft()); // Go to the left of the current
        String current = cur.getData() + " "; // Process the current Node
        String right = inorderRecursive(cur.getRight()); // Go to the right of the current 

        return left + current + right; // add all of the strings from left, current, and right
    }

    private String preorderRecursive(Node cur){
        // if the current node is null return an empty string
        if (cur == null){
            return "";
        }

        String current = cur.getData() + " "; // Process the current Node
        String left = inorderRecursive(cur.getLeft()); // Go to the left of the current Node
        String right = inorderRecursive(cur.getRight()); // Go to the right of the current Node

        return current + left + right; // add all of the strings from current, left, and right
    }

    private String postorderRecursive(Node cur){
        // if the current node is null then return an empty string
        if (cur == null){
            return "";
        }

        String left = inorderRecursive(cur.getLeft()); // Go to the left of the current Node
        String right = inorderRecursive(cur.getRight()); // Go to the right of the current Node
        String current = cur.getData() + " "; // Process the current Node
        
        return left + right + current; // add all of the string from left, right, and current
    }

    private void case0(Node prev, Node cur, int value){
        if (root.getData() == value){
            root = null;
            return;
        }
        if (prev.getLeft() != null && prev.getLeft().getData() == value){
            prev.setLeft(null);
            return;
        } else {
            prev.setRight(null);
            return;
        }
    }

    private void case1(Node prev, Node cur, int value){
        // If the left node of the previous is not null and the left node of the previous
        // is equal to the value we want removed
        if(prev.getLeft() != null && prev.getLeft().getData() == value){
            // If the current's left node is not null
            if(cur.getLeft() != null){
                // set the previous node's left pointer to the current's right
                prev.setLeft(cur.getLeft());
            } else {
                // set the previous node's left pointer to the current's right
                prev.setLeft(cur.getRight());
            }
        } 
        // Same logic as above just changing the previous node's right pointer
        else {
            if(cur.getLeft() != null){
                prev.setRight(cur.getLeft());
            } else {
                prev.setRight(cur.getRight());
            }
        }
    }

    private void case2(Node prev, Node cur, int value){
        Node successorParent = cur;
        Node successor = cur.getRight();
        // Find the successor and its parent
        while (successor.getLeft() != null){
            successorParent = successor;
            successor = successor.getLeft();
        }
        if(successorParent != cur){
            successorParent.setLeft(successor.getRight());
        } else {
            successorParent.setRight(successor.getRight());
        }

        cur.data = successor.data;

    }


}

