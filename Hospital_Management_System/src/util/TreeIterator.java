package util;

import java.util.Stack;
import util.BinarySearchTree.Node;
/**
 * Tree Iterator for traversing binary search tree.
 */
public class TreeIterator<E extends Comparable<E>>{

    private Stack<Node<E>> stack = new Stack<Node<E>>();
    private Node<E> current;

    /*This is the constructor for the TreeIterator class. It takes in a node and sets the current node
     * to the node that was passed in.
     */
    public TreeIterator(Node<E> argRoot) {
        current = argRoot;
    }

    /**
     * While there is a left child, push the current node onto the stack, then move to the left child.
     * Then pop the stack and return the node, and move to the right child.
     * 
     * @return The node that is being returned is the node that is being popped off the stack.
     */
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

    /**
     * If the stack is empty and the current node is null, then there are no more nodes to traverse
     * 
     * @return The method returns true if the stack is not empty or if the current node is not null.
     */
    public boolean hasNext() {
        return (!stack.isEmpty() || current != null);
    }

}