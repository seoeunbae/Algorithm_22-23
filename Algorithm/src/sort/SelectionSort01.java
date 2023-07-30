package sort;
//원리: 리스트를 순환하면서 가장 작은 값을 맨 앞으로 보낸다.
//리스트의 사이즈는 --1
//n번순환한다.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionSort01 {
    //데이터가 두개일때 동작하는 선택정렬 알고리즘
    static List<Integer> dataList = new ArrayList<>();

    public static void main(String[] args) {
        dataList.add(9);
        dataList.add(1);
        if(dataList.get(0)> dataList.get(1)){
            Collections.swap(dataList, 0, 1);
        }

        System.out.println(dataList);
    }
}
