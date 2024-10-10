import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    static Scanner sc = new Scanner(System.in);

    public static Node buildTree(Node head) {
        int value = sc.nextInt();
        
        if (value == -1) {
            return null;
        }
        
        head = new Node(value);
        
        // Left child
        head.left = buildTree(head.left);
        
        // Right child
        head.right = buildTree(head.right);
        
        return head;
    }

    // Level Order Traversal
    public static void levelOrderTraversal(Node head) {
        if (head == null) {
            return;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(head);
        q.add(null);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp != null) {
                System.out.print(temp.data + " ");
                
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            } else {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            }
        }
    }

    // InOrder Traversal (Left - Node - Right)
    public static void inOrder(Node head) {
        if (head == null) {
            return;
        }
        
        inOrder(head.left); // Left
        System.out.print(head.data + " "); // Node
        inOrder(head.right); // Right
    }

    // PreOrder Traversal (Node - Left - Right)
    public static void preOrder(Node head) {
        if (head == null) {
            return;
        }
        
        System.out.print(head.data + " "); // Node
        inOrder(head.left); // Left
        inOrder(head.right); // Right
    }

    // PostOrder Traversal (Left - Right - Node)
    public static void postOrder(Node head) {
        if (head == null) {
            return;
        }
        
        inOrder(head.left); // Left
        inOrder(head.right); // Right
        System.out.print(head.data + " "); // Node
    }

    public static void main(String[] args) {
        // Example input: 1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 -1
        Node root = null;
        root = buildTree(root);

        System.out.println("Level Order Traversal: ");
        levelOrderTraversal(root);

        System.out.println("InOrder Traversal: ");
        inOrder(root);
        System.out.println();

        System.out.println("PreOrder Traversal: ");
        preOrder(root);
        System.out.println();

        System.out.println("PostOrder Traversal: ");
        postOrder(root);
        System.out.println();
    }
}
