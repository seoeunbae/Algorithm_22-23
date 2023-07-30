package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort01 {
    //재귀용법과 피봇을 사용
    public static class Split{

        public void splitFunc(ArrayList<Integer> dataList){
            if(dataList.size() <= 1){
                return;
            }
            int pivot = dataList.get(0);

            ArrayList<Integer> leftArr = new ArrayList<>();
            ArrayList<Integer> rightArr = new ArrayList<>();

            for(int index = 1; index < dataList.size(); index++){
                if(dataList.get(index)> pivot){
                    rightArr.add(dataList.get(index));
                } else {
                    leftArr.add(dataList.get(index));
                }
            }

            ArrayList<Integer> mergedArr = new ArrayList<>();
            mergedArr.addAll(leftArr);
            mergedArr.addAll(Arrays.asList(pivot));
            mergedArr.addAll(rightArr);

            System.out.println(leftArr);
            System.out.println(pivot);
            System.out.println(rightArr);
            System.out.println(mergedArr);
        }
    }

    public static void main(String[] args) {
        Integer[] array = {4,1,2,5,7};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));

        Split split = new Split();
        split.splitFunc(list);
    }
}
