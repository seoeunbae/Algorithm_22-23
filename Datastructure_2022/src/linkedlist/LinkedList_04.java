package linkedlist;

public class LinkedList_04 {
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

        public boolean insertNodePrev(T data, T isData){
            if( head == null){
                head = new Node<T>(data);
                tail = head;
                return true;
            } else if(this.head.data == isData){
//                Node<T> node = head;
//                while( node != null){
//                    if( node.data == isData){
//
//                    }
//                }
                Node<T> newHead = new Node<>(data);
                newHead.next = head;
                head = newHead;
                return true;
            } else {
                Node<T> node = this.head;
                while(node != null){
                    if(node.data == isData){
                        Node<T> nodePrev = node.prev;
                        nodePrev.next = new Node<>(data);
                        nodePrev.next.next = node;

                        nodePrev.next.prev = nodePrev;
                        node.prev = nodePrev.next;
                        return true;
                    } else{
                        node = node.next;
                    }

                }
                return false;
            }
        }
    }


    public static void main(String[] args) {
        DoubleLinkedList myDoubleLinkedlist = new DoubleLinkedList();
        myDoubleLinkedlist.addNode(10);
        myDoubleLinkedlist.addNode(20);
        myDoubleLinkedlist.addNode(30);
        myDoubleLinkedlist.addNode(40);
        myDoubleLinkedlist.printAll();
        System.out.println();
        myDoubleLinkedlist.insertNodePrev(15,20);
        myDoubleLinkedlist.printAll();
    }
}
