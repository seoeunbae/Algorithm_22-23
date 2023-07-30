package search;

import java.util.ArrayList;

public class SequentialSearch {
    public int searchFunc(ArrayList<Integer> dataList, Integer data){
        for(int index= 0 ; index<dataList.size(); index++ ){
            if(dataList.get(index) == data){
                return index;
            }
        }
        return -1;
    }
}
//ㅅㅣ간복잡도: O(n)
