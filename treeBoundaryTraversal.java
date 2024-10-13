import java.util.*;
// Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class Solution {
    public void traverseLeft(Node head, List<Integer> result) {
        // Base Cases
        if (head == null || (head.left == null && head.right == null)) {
            return;
        }
        
        result.add(head.data);
        
        if (head.left != null) {
            traverseLeft(head.left, result);
        } else {
            traverseLeft(head.right, result);
        }
    }

    public void traverseLeaf(Node head, List<Integer> result) {
        // Base Case
        if (head == null) {
            return;
        }
        
        if (head.left == null && head.right == null) {
            result.add(head.data);
            return;
        }

        traverseLeaf(head.left, result);
        traverseLeaf(head.right, result);
    }

    public void traverseRight(Node head, List<Integer> result) {
        // Base Case
        if (head == null || (head.left == null && head.right == null)) {
            return;
        }

        if (head.right != null) {
            traverseRight(head.right, result);
        } else {
            traverseRight(head.left, result);
        }

        result.add(head.data);  // Add after recursive call for reverse order
    }

    public List<Integer> boundary(Node head) {
        List<Integer> result = new ArrayList<>();
        
        if (head == null) {
            return result;
        }

        // Add root node
        result.add(head.data);

        // Traverse left boundary
        traverseLeft(head.left, result);

        // Traverse leaf nodes
        traverseLeaf(head.left, result);
        traverseLeaf(head.right, result);

        // Traverse right boundary
        List<Integer> rightBoundary = new ArrayList<>();
        traverseRight(head.right, rightBoundary);

        // Add right boundary in reverse order
        for (int i = rightBoundary.size() - 1; i >= 0; i--) {
            result.add(rightBoundary.get(i));
        }

        return result;
    }
}

public class Main {
    // Utility function to create a new Tree Node
    public static Node newNode(int val) {
        return new Node(val);
    }

    // Function to Build Tree
    public static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        // Split input string by spaces
        String[] ip = str.split(" ");
        // Create the root of the tree
        Node root = newNode(Integer.parseInt(ip[0]));

        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while (!queue.isEmpty() && i < ip.length) {
            // Get and remove the front of the queue
            Node currNode = queue.poll();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {
                // Create the left child for the current node
                currNode.left = newNode(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length)
                break;
            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {
                // Create the right child for the current node
                currNode.right = newNode(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            Node root = buildTree(s);
            Solution ob = new Solution();
            List<Integer> res = ob.boundary(root);
            for (int val : res) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}