import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

class Node {
    int key;
    Node left, right;
    Node (int key) {
       this.key = key; 
       this.left = null;
       this.right = null;
    }
}

public class BinaryTree {
    public static Node root;
    int level, edges, nodeCount;
    public BinaryTree(int key) {
        this.root = new Node(key);
        this.nodeCount = 1;
        this.level = (int) Math.floor(Math.log(nodeCount) / Math.log(2)) + 1;
        this.edges = this.nodeCount - 1; // n - 1
    }
 
    public void insert(int key) {
      
        // If the tree is empty, simply do nothing and return
        if (this.root == null) {
            return;
        }

        // We perform level order traversal (BFS) until we find an empty place
        // either left or right child of some node pointing to null
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty()) { 
            Node node = queue.poll(); // Queue dequeues

            // First check left if left is null insert node in left otherwise check for right
            if (node.left != null)
                queue.add(node.left);
            else {
                node.left = new Node(key);
                break;
            }

            if (node.right != null)
                queue.add(node.right);
            else {
                node.right = new Node(key);
                break;
            }
        }

        this.nodeCount++;
        this.level = (int) Math.floor(Math.log(nodeCount) / Math.log(2)) + 1;
        this.edges = this.nodeCount - 1; // n - 1
    }
 
    public void delete(int key) {
        if (this.root == null)
            return;

        // If the tree has only one node
        if (this.nodeCount == 1) { 
            // If the root node is the key, delete it
            if (this.root.key == key) {
                this.root = null;
                this.nodeCount = 0;
                this.level = 0;
                this.edges = 0;
            }
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);

        Node current = null;
        Node keyNode = null;

        // Perform level order traversal to find the deepest node and the key node
        while (!queue.isEmpty()) {
            current = queue.poll();

            // If current node is the key node
            if (current.key == key)
                keyNode = current;

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
        }

        // If key node is found, replace its
        // data with the deepest node
        if (keyNode != null) {
          
            // Store the data of the
            // deepest node
            int x = current.key; 
          
            // Replace key node data with 
            // deepest node's data
            keyNode.key = x; 
          
            // Delete the deepest node
            deleteDeepestNode(current);
        }

    }

    private void deleteDeepestNode(Node dNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);

        Node current;
        while (!queue.isEmpty()) {
            current = queue.poll();

            // If current node is the deepest node, delete it
            if (current == dNode) {
                current = null;
                dNode = null;
                return;
            }

            // Check the right child first
            if (current.right != null) {
              
                // If right child is the deepest node,
                  // delete it
                if (current.right == dNode) {
                    current.right = null;
                    dNode = null;
                    return;
                }
                queue.add(current.right);
            }

            // Check the left child
            if (current.left != null) {
              
                // If left child is the deepest node,
                  // delete it
                if (current.left == dNode) {
                    current.left = null;
                    dNode = null;
                    return;
                }
                queue.add(current.left);
            }
        }
    }


    public String preorder() {
        return preorder_recursive(this.root, "");
    }

    public String inorder() {
        return inorder_recursive(this.root, "");
    }

    public String postorder() {
        return postorder_recursive(this.root, "");
    }

    private String preorder_recursive(Node current, String res) {
        if (current == null) {
            return res;
        }
        res += current.key + " ";
        res = preorder_recursive(current.left, res);
        res = preorder_recursive(current.right, res);
        return res;
    }

    private String inorder_recursive(Node current, String res) {
        if (current == null) {
            return res;
        }
        res = inorder_recursive(current.left, res);
        res += current.key + " ";
        res = inorder_recursive(current.right, res);
        return res;
    }

    private String postorder_recursive(Node current, String res) {
        if (current == null) {
            return res;
        }
        res = postorder_recursive(current.left, res);
        res = postorder_recursive(current.right, res);
        res += current.key + " ";
        return res;
    }
    
    public String bfs() {
        // Initialize queue, then add the root node
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);
        // Initialize a string to store the traversal sequence
        // when a node is traversed, it should be added to the queue
        String result = "";
        while (!queue.isEmpty()) {
            Node node = queue.poll(); // Queue dequeues
            result += node.key + " "; // Concatenate node key into string
            if (node.left != null)
                queue.offer(node.left);   // Left child node enqueues
            if (node.right != null)
                queue.offer(node.right);  // Right child node enqueues
        }
        return result;
    }

}
