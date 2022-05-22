package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort03 {
    public static class QuickSort{
        public ArrayList<Integer> sort(ArrayList<Integer> dataList){
            if(dataList.size()<1){
                return dataList;
            } else {
                ArrayList<Integer> leftArray = new ArrayList<>();
                ArrayList<Integer> rightArray = new ArrayList<>();

                Integer pivot = dataList.get(0);
                for(int index = 1 ; index< dataList.size()-1 ; index++){
                    if(dataList.get(index)> pivot){
                        rightArray.add(dataList.get(index));
                    } else {
                        leftArray.add(dataList.get(index));
                    }
                }

                ArrayList<Integer> mergedSort = new ArrayList<>();
                mergedSort.addAll(this.sort(leftArray));
                mergedSort.addAll(Arrays.asList(pivot));
                mergedSort.addAll(this.sort(rightArray));
                System.out.println(mergedSort);
                return mergedSort;

            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();

        for(int i = 0 ; i < 100 ; i++){
            testData.add((int)(Math.random()*100));
        }

        QuickSort qsort = new QuickSort();
        qsort.sort(testData);

    }
}
