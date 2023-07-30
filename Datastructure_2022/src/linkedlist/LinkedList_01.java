package linkedlist;

public class LinkedList_01 {
    public static class Node<T>{
        T data;
        Node<T> next = null; // pointer

        public Node(T data){
            this.data = data;
        }

    }

    public static class SingleLinkedList<T>{
        public Node<T> head = null;

        public static class Node<T>{
            T data;
            Node<T> next = null; // pointer

            public Node(T data){
                this.data = data;
            }
        }
        //메소드추가(데이터 새로 추가하는 메소드)
        public void addNode(T data){
            if(head == null){
                head = new Node<>(data);
            } else {
                Node<T> node = this.head;
                while(node.next !=null){
                    node = node.next;
                }
                node.next = new Node<T>(data);
            }
        }

        //모든 데이터를 출력하는 메소드
        public void printAll(){
            if( head != null){
                Node<T> node = this.head;
                System.out.println(node.data);
                while(node.next != null){
                    node = node.next;
                    System.out.println(node.data);
                }
            }
        }
    }

    public static void main(String[] args) {
        //1.NOde설정하기
        //2.Node인스턴스두개 생성후 두개를 연결해주기
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        node1.next = node2;
        //맨앞임을 나타내는 노드(head)에 생성한 노드중, 제일 앞노드를 연결
        Node<Integer> head = node1;

        SingleLinkedList<Integer> MyLinkedList = new SingleLinkedList<>();
        MyLinkedList.addNode(1);
        System.out.println(MyLinkedList.head.data);
        MyLinkedList.addNode(2);
        System.out.println(MyLinkedList.head.next.data);

    }




}
