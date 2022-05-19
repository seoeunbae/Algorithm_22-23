package sort;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionSort01 {
    //두 개일때 동작
    List<Integer> dataList = new ArrayList<>();

    public void sort(List<Integer> dataList){
        if( dataList.get(0)>dataList.get(1)){
            Collections.swap(dataList, 0 , 1);
        }
        System.out.println(dataList);
    }
}
