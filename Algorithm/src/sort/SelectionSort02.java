package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//데이터가 세개 일때 동작하는 선택 정렬 알고리즘
public class SelectionSort02 {
    static List<Integer> dataList = new ArrayList<>();

    public static void main(String[] args) {
        dataList.add(9);
        dataList.add(1);
        dataList.add(7);

        for(int i=0;i<dataList.size()-1;i++){
            if(dataList.get(i) > dataList.get(i+1)){
                Collections.swap(dataList, i,i+1);
            }
        }
        System.out.println(dataList);
    }
}
