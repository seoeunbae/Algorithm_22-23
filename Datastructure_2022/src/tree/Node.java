package tree;

public class Node {

    public static class InternalNode<E,T> implements BinNode<E>{
        public E item;
        public T left;
        public T right;
        public InternalNode(E item , T left, T right){
            this.item = item;
            this.left = left;
            this.right = right;

        }

        @Override
        public void put() {

        }
    }

    public static class LeafNode<E> implements BinNode<E>{
        public E item;
        public LeafNode(E item){
            this.item = item;

        }

        @Override
        public void put() {

        }
    }

    public static void main(String[] args) {
        InternalNode<Integer, InternalNode> root = new InternalNode<>(1, null,null);

        InternalNode<Integer, InternalNode> rightNInternal = new InternalNode<>(2, null,null);
        InternalNode<Integer, BinNode> rightNBin = new InternalNode<>(2, null,null);
        InternalNode<Integer, InternalNode > thirdNode = new InternalNode<>(3, null,null);

        root.right = rightNInternal;
        rightNInternal.right= thirdNode;


        LeafNode<Integer> leafN = new LeafNode<>(1);
        rightNBin.right = leafN;
        root.right.left= new LeafNode<>(1);
        System.out.println();

    }

    public interface BinNode<E>{
        public void put();
    }
}
