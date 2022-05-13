package tree;


public class Tree_01 {
    Node head = null;
    public static class Node{
        Node left;
        Node right;
        int value;

        public Node(int data){
            this.value = data;
            left = null;
            right = null;
        }

    }

    public boolean insertNode(int data){
        if( this.head == null){
            this.head = new Node(data);
        } else {
            Node findNode = head;
            while(true){
                //노드의 왼쪽에 드러가야할때
                if(data < head.value){
                    if(findNode.left != null){
                        findNode = findNode.left;
                    } else{
                        findNode.left = new Node(data);
                        break;
                    }
                } else{
                    //노드의 오른쪽에 들어가야할때
                    if(findNode.right != null){
                        findNode = findNode.right;
                    } else{
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public Node searchNode(int data){
        //node가 하나도 없을때
        if(head == null){
            return null;
        } else{
            //node가 하나이상 있을때
            Node findNode = head;
            while(findNode != null){
                if(findNode.value == data){
                    return findNode;
                } else if(data < findNode.value ){
                    findNode = findNode.left;
                } else{
                    findNode = findNode.right;
                }
            }
            //다 순회했는데 없을떄
            return null;
        }

    }

    public static void main(String[] args) {
        Tree_01 tree = new Tree_01();
        tree.insertNode(10);
        tree.insertNode(20);
        tree.insertNode(30);
        tree.insertNode(40);
        tree.insertNode(50);
        Node searchedNode = tree.searchNode(30);
        System.out.println(searchedNode.right.value);
    }

}
