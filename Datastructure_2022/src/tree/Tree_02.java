package tree;
//노드 삭제하기
public class Tree_02 {

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

    public boolean delete(int value){
        boolean searched = false;

        Node currParentNode = this.head;
        Node currNode = this.head;

        if(head == null){
            return false;
        } else{
            if(this.head.value == value && this.head.left == null && this.head.left == null){
                this.head= null;
                return true;
            }
        }

        while(currNode != null){
            if(currNode.value == value){
                searched = true;
                break;
            } else if(value < currNode.value){
                currParentNode = currNode;
                currNode = currNode.left;
            } else {
                currParentNode = currNode;
                currNode = currNode.right;
            }
        }
        if(searched == false){
            return false;
        }
        //여기까지 실행되었을떄,
        //currNode에는 해당 데이터를 가지고 있는 노드가,
        //currParentNode에는 해당 데이터를 가지고 있는 노드의 부모노드가 있다.


        //1.leafnode를 삭제(childnode가 하나도 없을때)
        //2.childnode가 하나인 애를 삭제
        //3.childnode가 두개인 애를 삭제
        //-> 삭제할 노드의 오른쪽 자식중, 가장 작은 값을 삭제할노드의 부모노드(의 left)가 가리키도록 한다.
        if(currNode.left == null & currNode.right == null){
            if(value<currParentNode.value){
                currParentNode.left = null;
                currNode = null;
            } else {
                currParentNode.right = null;
                currNode = null;
            }
        } else if(currNode.left != null && currNode.right == null){
            if(value < currParentNode.value){
                currParentNode.left = currNode.left;
                currNode = null;
            } else {
                currParentNode.right = currNode.left;
                currNode = null;
            }


        } else if( currNode.left == null && currNode.right != null){
            if(value< currParentNode.value){
                currParentNode.left = currNode.right;
                currNode = null;
            } else {
                currParentNode.right = currNode.right;
                currNode = null;
            }
        } else{ //case3-1: 삭제할 node가 두개 가지고 있고, 삭제할 node가 부모 node의 왼쪽에 있을 때,

            //삭제할 node가 부모 node의 왼쪽에 있을 때,
            if(value < currParentNode.value){
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;

                while(changeNode.left != null){
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Tree_02 tree = new Tree_02();
        tree.insertNode(10);
        tree.insertNode(20);
        tree.insertNode(30);
        tree.insertNode(40);
        tree.insertNode(50);
        Node searchedNode = tree.searchNode(30);
        System.out.println(searchedNode.right.value);
    }


}
