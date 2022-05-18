package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//범용적으로 적용되는 선택정렬알고리즘
public class SelectionSort03 {

    List<Integer> dataList = new ArrayList<>();
    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        int lowest;
        for(int stand = 0 ; stand < dataList.size()-1 ; stand++){
            lowest = stand;
            for(int index = stand+1;index< dataList.size();index++){
                if(dataList.get(lowest) > dataList.get(index)){
                    lowest = index;
                }
            }
            Collections.swap(dataList, lowest, stand);
        }
        return dataList;
    }

}
//시간복잡도는 버블정렬과 동일: O(N^2)
