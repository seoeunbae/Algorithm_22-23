package sort;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort03 {
    //삽입 정렬 알고리즘 정리
    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        for(int index = 0 ; index < dataList.size() -1 ; index++){
            for(int index2 = index +1 ; index2> 0 ; index2--){ //점점 비교리스트들이 줄어든다.
                if(dataList.get(index2)< dataList.get(index2-1)){
                    Collections.swap(dataList, index2, index2-1);
                } else {
                    break;
                }

            }

        }
        return dataList;
    }
}
//시간복잡도: O(n^2)
