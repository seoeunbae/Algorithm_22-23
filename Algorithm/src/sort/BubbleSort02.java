package sort;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
//데이타가 세개일때 버블정렬 알고리즘 방식을 정렬해보세요.
public class BubbleSort02 {
    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<>();
        dataList.add(9);
        dataList.add(2);
        dataList.add(4);

        for(int index= 1; index< dataList.size();index++){
            if(dataList.get(index-1)> dataList.get(index)){
                Collections.swap(dataList, index-1, index);
            }
        }
        System.out.println(dataList);
    }
}
