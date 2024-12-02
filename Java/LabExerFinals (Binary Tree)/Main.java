public class Main {
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree(10);
        tree.insert(11);
        tree.insert(9);
        tree.insert(7);
        tree.insert(12);
        tree.insert(15);
        tree.insert(8);
        
        tree.delete(11);
        // System.out.println(tree.preorder());
        System.out.println(tree.inorder());
        // System.out.println(tree.postorder());
        System.out.println(tree.bfs());
    }
}
