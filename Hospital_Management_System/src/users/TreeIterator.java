package users;

import java.util.Stack;
import users.BinarySearchTree.Node;

public class TreeIterator<E extends Comparable<E>>{

    private Stack<Node<E>> stack = new Stack<Node<E>>();
    private Node<E> current;

    public TreeIterator(Node<E> argRoot) {
        current = argRoot;
    }

    public Node<E> next() {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        current = stack.pop();
        Node<E> node = current;
        current = current.right;

        return node;
    }

    public boolean hasNext() {
        return (!stack.isEmpty() || current != null);
    }

}