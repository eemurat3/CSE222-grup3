package users;

import java.util.Stack;
import users.BinarySearchTree.Node;

public class TreeIterator {

    private Stack<Node> stack = new Stack<>();
    private Node current;

    private TreeIterator(Node argRoot) {
        current = argRoot;
    }

    public Node next() {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        current = stack.pop();
        Node node = current;
        current = current.right;

        return node;
    }

    public boolean hasNext() {
        return (!stack.isEmpty() || current != null);
    }

    public static TreeIterator iterator(Node root) {
        return new TreeIterator(root);
    }
}