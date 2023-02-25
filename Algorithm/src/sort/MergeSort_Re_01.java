package sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MergeSort_Re_01 {
    static ArrayList<Integer> list = new ArrayList<>(List.of(50,49,0,5,3,10,20,15,13,24,17));

    public static void main(String[] args) {
        Split split = new Split();

    }
    public static class Split{
        public static ArrayList<Integer> splitFunc(ArrayList<Integer> dataList){
            if(dataList.size() <= 1) return dataList;

            int medium = dataList.size() / 2;

            ArrayList<Integer> leftList = new ArrayList<>();
            ArrayList<Integer> rightList = new ArrayList<>();

            leftList = splitFunc(new ArrayList<>(dataList.subList(0, medium)));

            rightList = splitFunc(new ArrayList<>(dataList.subList(medium, dataList.size())));

            return mergeFunc(leftList, rightList);

        }

    }

    public static ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList){

    }
}
