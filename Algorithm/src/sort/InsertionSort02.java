package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionSort02 {
    //3개 일때
    List<Integer> dataList = new ArrayList<>();

    public void sort(List<Integer> dataList){
        for(int i = 0 ; i< dataList.size() - 1 ; i++){
            if(dataList.get(i)> dataList.get(i+1)){
                Collections.swap(dataList,i,i+1);
            }
        }
        System.out.println(dataList);
    }
}
