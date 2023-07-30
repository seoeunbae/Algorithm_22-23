package tree;

import javax.management.NotificationEmitter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_1991_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        Node head = new Node("A", null, null);

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            String root = s[0];
            String left = s[1];
            String right = s[2];

            insertNode(head, root, left, right);


        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();

    }

    public static class Node {
        String value;
       Node left;
       Node right;

        Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void insertNode(Node head, String root, String left, String right) {
        if (head.value.equals(root)) {
            head.left = (left.equals(".") ? null : new Node(left, null, null));
            head.right = (right.equals(".") ? null : new Node(right, null, null));
        } else {
            if (head.left != null) insertNode(head.left, root, left, right);
            if (head.right != null) insertNode(head.right, root, left, right);
        }

    }

    public static void preOrder(Node node){
        if(node == null) return;
        Stack<Node> stack = new Stack<>();
        stack.add(node);

        while(!stack.isEmpty()){
            Node pop = stack.pop();
            System.out.print(pop.value);
            if(pop.right!=null){
                stack.add(pop.right);
            }
            if(pop.left!=null){
                stack.add(pop.left);
            }

        }
    }

    public static void inOrder(Node node){
        if(node == null) return;
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        Node temp = node;

        while(temp.left != null){
            stack.add(temp.left);
            temp = temp.left;
        }

        while(!stack.isEmpty()){
            Node pop = stack.pop();
            System.out.print(pop.value);
            if(pop.right!=null){
                stack.add(pop.right);
                if(pop.right.left!=null) stack.add(pop.right.left);
            }

        }
    }

    public static void postOrder(Node node){
        if(node == null) return;
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        Node temp = node;
        Node last = node;

        while(temp.left != null){
            stack.add(temp.left);
            temp = temp.left;
        }

        while(!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.print(pop.value);
            last = pop;
            if(pop.right!=null){
                if(!last.value.equals(pop.right.value)) {
                    stack.add(pop.right);
                }

            }

        }


    }
}
