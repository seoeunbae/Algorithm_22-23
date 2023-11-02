package linkedlist;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class swea_n03 {
    static BufferedReader in;
    static StringTokenizer st;

    public static void main(String[] args) {

    }

    public static class Node<T>{
        T value;
        Node next;

        Node(T value){
            this.value = value;
        }
    }

    public static class LinkedList<T>{
        private Node<T> head;
        private Node<T> tail;

        public void add(T value){
            if(head == null){
                head = new Node<>(value);
                this.tail=this.head;
            }else{
                Node<T> node = this.head;
                while(node.next != null){
                    node = node.next;
                }
                node.next = new Node<>(value);
                tail=node.next;
            }
        }

    }
}
