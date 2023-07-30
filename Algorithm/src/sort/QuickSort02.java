package sort;

import java.util.ArrayList;
import java.util.Arrays;
//Quicksort01에서 재귀용법 적용하기
public class QuickSort02 {
    public static class QuickSort{

        public ArrayList<Integer> sort(ArrayList<Integer> dataList){
            if(dataList.size() <= 1){
                return dataList;
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
            mergedArr.addAll(this.sort(leftArr));
            mergedArr.addAll(Arrays.asList(pivot));
            mergedArr.addAll(this.sort(rightArr));

            System.out.println(leftArr);
            System.out.println(pivot);
            System.out.println(rightArr);
            System.out.println(mergedArr);
            return mergedArr;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> datas = new ArrayList<>();
        for(int index = 0 ; index< 100; index++){
            datas.add((int)(Math.random()*100));
        }

        QuickSort qsort = new QuickSort();
        qsort.sort(datas);

    }
}

//시간복잡도:O(nlogn)
//각단계별 순회개수:n, 단계의 개수: logn

