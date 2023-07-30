package sort;

import java.util.ArrayList;
import java.util.Collections;
//data가 두개 일때 버블 정렬 알고리즘 방식으로 정렬해보세요.
public class BubbleSort01 {
    static ArrayList<Integer> dataList = new ArrayList<Integer>();

    public static void main(String[] args) {
        dataList.add(4);
        dataList.add(2);

        if (dataList.get(0) > dataList.get(1)) {
            Collections.swap(dataList, 0, 1);
        }
        System.out.println(dataList);
    }

}
