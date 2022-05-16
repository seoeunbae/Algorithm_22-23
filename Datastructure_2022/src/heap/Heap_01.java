package heap;

import java.util.ArrayList;
import java.util.Collections;

public class Heap_01 {
    //힙과 이진탐색트리의 차이점: 힙은 작은값<노드<큰값 이라는 조건이 없다.
    //왼쪽 자식노드인덱스 = 부모노드인덱스 * 2
    //오른쪽 자식노드인덱스 = 부모노드인덱스 * 2 + 1
    public static class Heap{
        public ArrayList<Integer> heapArray = null;
        public Heap(Integer data){
            heapArray = new ArrayList<>();
            heapArray.add(null); // 계산편의성을 위해 0번은 null로 하고 1번부터 시작한다.
            heapArray.add(data);
        }
        public boolean insert(Integer data){
            Integer inserted_idx, parent_idx;

            if(heapArray == null){
                heapArray = new ArrayList<>();
                heapArray.add(null);
                heapArray.add(data);
                return true;
            }

            heapArray.add(data);
            inserted_idx = heapArray.size()-1;
            while(this.move_up(inserted_idx)){
                parent_idx = inserted_idx/2;
                Collections.swap(this.heapArray,inserted_idx,parent_idx);
                inserted_idx = parent_idx;
            }
            return true;
        }

        public boolean move_up(Integer inserted_idx){
            if(inserted_idx <= 1){
                return false;
            }
            Integer parent_idx = inserted_idx / 2;
            if(this.heapArray.get(inserted_idx) > this.heapArray.get(parent_idx)){
                return true;
            } else {
                return false;
            }
        }


    }



    public static void main(String[] args) {
        Heap heap = new Heap(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);

    }
}
