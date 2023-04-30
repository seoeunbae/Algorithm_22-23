package unsolved;

import com.sun.source.tree.Tree;
import com.sun.source.tree.TreeVisitor;

import java.util.Stack;

public class DividePlace {

    public class Node{
        private Node leftNode;
        private Node rightNode;
        private int value;

        Node(Node leftNode, Node rightNode, int value){
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        Integer pop = stack.pop();
    }
}
