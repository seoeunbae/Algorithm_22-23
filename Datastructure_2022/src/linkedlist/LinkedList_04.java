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

        public boolean insertNodePrevSelf(T data, T isData ){
            if( head == null){
                head = new Node<T>(data);
                tail = head;
                return true;
            } else {
                Node<T> node = head;
                while( node != null){
                    if( node.data == isData){
                        Node<T> newNode = new Node<>(data);
                        newNode.prev = node.prev;
                        node.prev.next = newNode;
                        newNode.next = node;
                        node.prev = newNode;
                        //순서중요!
//                      !! 기준노드가 헤드노드일경우, 122줄에서 node.prev==null인데 접근하기때문에, nullpointexcpetion이 나옴
//                      따로 if문을 통해 1. 기준이 head노드인 경우 2. 중간노드에 insert인 경우 두가지로 분기를 해줘야한다
//                      위에 모범답안 참고하기.
                        return true;
                    } else {
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
        myDoubleLinkedlist.insertNodePrev(5,10);
        myDoubleLinkedlist.printAll();
    }


}
