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
    int level, edges;
    public BinaryTree(int key) {
        this.root = new Node(key);
        this.level = 1;
        this.edges = this.level - 1; // n - 1
    }

    public void insert(int key) {
        // Decide where to place the node, starting from the root node
        Node temp = this.root;
        while (true) {
            if (key >= temp.key) { // Insert to right
                if (temp.right == null) {
                    temp.right = new Node(key);
                    break;
                }
                temp = temp.right;
                continue;
            }
            if (key <= root.key) { // Insert to left
                if (temp.left == null) {
                    temp.left = new Node(key);
                    break;
                }
                temp = temp.left;
                continue;
            }
        }

        this.level++;
        this.edges = this.level - 1;
    }
    
    public void delete(int key) {
                
    }

    
    public void printBFS() {
        // Initialize queue, then add the root node
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);
        // Initialize a list to store the traversal sequence
        // when a node is traversed, it should be added to the queue
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll(); // Queue dequeues
            list.add(node.key);           // Save node value
            if (node.left != null)
                queue.offer(node.left);   // Left child node enqueues
            if (node.right != null)
                queue.offer(node.right);  // Right child node enqueues
        }
        System.out.println(list.toString());
    }

}
