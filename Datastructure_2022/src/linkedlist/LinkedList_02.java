package linkedlist;
//linkedlist 사이에 데이터를 추가하는 기능, 삭제하는 기능
public class LinkedList_02 {
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
                node.next = new Node<>(data);
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

        private Node<T> search(T data){
            if(this.head == null){
                return null;
            } else {
//                Node<T> node = head;
//                while(node.next != null){
//                    T thisData = node.data;
//                    if(thisData == data){
//                        return node;
//                    }
//                    node = node.next;
//                }
//                return null;
                //윗부분은 혼자구현, 아래는 모범답안
                Node<T> node = this.head;
                while(node != null){
                    if(node.data == data){
                        return node;
                    } else{
                        node = node.next;
                    }
                }
                return null;
            }

        }

        public void addNodeInside(T data, T isData){
            Node<T> searchedNode = this.search(isData);
            //데이터를 넣을 기준데이터가 없는 경우는 맨 뒤에 넣는다.
            if(searchedNode == null){
                this.addNode(data);
            } else {
                Node<T> nextNode = searchedNode.next; //추가하기전의 상태
                searchedNode.next = new Node<>(data); //중간에 추가
                searchedNode.next.next = nextNode; //연결완료


            }
        }
        public boolean delNode(T isData){
            if(this.head == null){
                return false;
            } else{//삭제할 데이터가 헤드인경우
                Node<T> node = head;
                if(node.data == isData){
                    //delete
                    this.head = this.head.next;
                    return true;
                } else { //삭제할 데이터가 헤드가 아닌경우
                    while(node.next != null){
                        if(node.next.data == isData){
                            node.next = node.next.next;
                            return true;
                        }else{
                            node = node.next;
                        }
                    }
                    return false;
                }
            }
        }
    }


    public static void main(String[] args) {
        SingleLinkedList<Integer> myLinkedList = new SingleLinkedList<>();
        myLinkedList.addNode(12);
        myLinkedList.addNode(30);
        myLinkedList.addNode(19);
        myLinkedList.printAll();
        System.out.println();
        myLinkedList.addNodeInside(29,12);
        myLinkedList.printAll();
        System.out.println();
        System.out.println(myLinkedList.delNode(30));
        myLinkedList.printAll();
    }

}
