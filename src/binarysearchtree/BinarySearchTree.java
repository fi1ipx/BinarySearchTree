
import java.util.Scanner;



class Node
{
    int data;
    Node left, right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
}

/* Class to print the Diameter */
class BinarySearchTree
{
    Node root;

    public Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        }
        else {
            if (data <= node.data)
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }

    void preorder(Node node, int data, boolean flag) {
        if (node != null) {
            if (data == node.data || flag) {
                System.out.println(node.data);
                flag = true;
            }
            preorder(node.left, data, flag);
            preorder(node.right, data, flag);
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        BinarySearchTree tree = new BinarySearchTree();
        int data = 0;
        for (int i = 0; i <= T - 1; i++) {
            data = input.nextInt();
            if (i == 0)
                tree.root = new Node(data);
            else
                tree.insert(tree.root, data);
        }
        data = input.nextInt();
        tree.preorder(tree.root, data, false);
    }
}

