package search;

import java.util.*;

public class BinarySearch {
//    public Integer searchFunc(List<Integer> dataList, Integer data){
//        int searchIndex = dataList.size()/2;
//        if(dataList.get(searchIndex) == data){
//            return searchIndex;
//        } else if(dataList.get(searchIndex) < data){
//            dataList  = dataList.subList(searchIndex+1, dataList.size());
//            searchFunc(dataList,data);
//        } else{
//            dataList = dataList.subList(0, searchIndex+1);
//            searchFunc(dataList, data);
//        }
//        return -1;
//    }
    public boolean searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        if (dataList.size() == 1 && searchItem == dataList.get(0)) {
            return true;
        }
        if (dataList.size() == 1 && searchItem != dataList.get(0)) {
            return false;
        }
        if (dataList.size() == 0) {
            return false;
        }

        int medium = dataList.size() / 2;

        if (searchItem == dataList.get(medium)) {
            return true;
        } else {
            if (searchItem < dataList.get(medium)) {
                return this.searchFunc(new ArrayList<Integer>(dataList.subList(0, medium)), searchItem);
            } else {
                return this.searchFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())), searchItem);
            }
        }
    }

}
