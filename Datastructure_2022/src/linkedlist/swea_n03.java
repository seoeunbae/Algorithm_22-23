package linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_n03 {
    static BufferedReader in;
    static StringTokenizer st;
    static int[] array;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        array = new int[N];
        st = new StringTokenizer(st.nextToken());
        for(int i=0 ; i < N ; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        int cnt =Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0 ; i < cnt ; i++){
            boolean start = true;
            if(start){
                String cmd = st.nextToken();
                if(cmd.equals("I")){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for(int z=0 ; z < y ; z++){
                        int s = Integer.parseInt(st.nextToken());
                        list.insert(x++,s);
                    }
                }else if(cmd.equals("D")){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                }else{
                    int y = Integer.parseInt(st.nextToken());
                    int s = Integer.parseInt(st.nextToken());
                }
            }
        }
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

        public void insert(int x , T value){
            Node<T> node = this.head;
            while (node.next != null && x > 0) {
                node = node.next;
                x--;
            }
            node.next.next = node.next;
            node.next = new Node<>(value);
        }

    }
}
