package linkedlist;


//double_linked_list
public class LinkedList_03 {
    public static class DoubleLinkedList<T>{
        public Node<T> head = null;
        public Node<T> tail = null;

        public class Node<T>{
            T data;
            Node<T> prev = null;
            Node<T> next = null;

            public Node(T data){
                this.data = data;

            }
        }
        public void addNode(T data){
            if(this.head == null){
                this.head = new Node<>(data);
                this.tail = this.head;
            } else {
                Node<T> node = this.head;
                while(node.next != null){
                    node = node.next;
                }
                node.next = new Node<>(data);
                node.next.prev = node;
                this.tail = node.next;
            }
        }

        public void printAll(){
            if(this.head != null){
                Node<T> node = this.head;
                System.out.println(node.data);
                while(node.next != null){
                    node = node.next;
                    System.out.println(node.data);
                }
            }
        }

        public T searchFromHead(T isData){
            if( head == null){
                return null;
            } else {
                Node<T> node = head;
                while ( node.next != null){//모범답안: (node != null)로 되어있음
                    if( node.data == isData){
                        return node.data;// return true;
                    } else node = node.next;

                } return null;
            }

        }

        public T searchFromTail(T isData){
            if( head == null){
                return null;
            } else {
                Node<T> node = tail;
                while( node != null){
                    if( node.data == isData){
                        return node.data;
                    } else node = node.prev;
                }
                return null;
            }

        }


    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> myDoublelist = new DoubleLinkedList<>();
        myDoublelist.addNode(1);
        myDoublelist.addNode(2);
        myDoublelist.addNode(3);
        myDoublelist.addNode(4);
        myDoublelist.printAll();
        System.out.println();
        System.out.println(myDoublelist.searchFromTail(2));
        System.out.println(myDoublelist.searchFromHead(3));
        System.out.println(myDoublelist.searchFromHead(5));
        System.out.println(myDoublelist.searchFromTail(6));
        System.out.println();
        myDoublelist.printAll();

    }

}
