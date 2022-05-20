package sort;

import java.util.ArrayList;

public class MergeSort01 {
    //배열을 앞뒤 두 배열로 짜르는 코드 작성(mergesort중에 분할하는과정에 사용됨)
    public class Split{
        public void splitFunc(ArrayList<Integer> dataList){
            if(dataList.size() <= 1){
                return ;
            }
            int medium = dataList.size() / 2;

            ArrayList<Integer> leftArr = new ArrayList<>();
            ArrayList<Integer> rightArr = new ArrayList<>();

            leftArr = new ArrayList<Integer>(dataList.subList(0, medium));
            rightArr = new ArrayList<>(dataList.subList(medium, dataList.size()));
        }
    }

    //병합정렬 코드
    public class MergeSort{
        public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList){
            if(dataList.size() <= 1){
                return dataList;
            }
            int medium = dataList.size()/2;

            ArrayList<Integer> leftArr = new ArrayList<Integer>();
            ArrayList<Integer> rightArr = new ArrayList<Integer>();

            leftArr = mergeSplitFunc(new ArrayList<>(dataList.subList(0, medium)));
            rightArr = mergeSplitFunc(new ArrayList<>(dataList.subList(medium, dataList.size())));

            return mergeFunc(leftArr, rightArr);
        }

        public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList){
            ArrayList<Integer> mergedList = new ArrayList<Integer>();
            int leftPoint = 0;
            int rightPoint = 0;

            //left/right 둘다 있을때
            while(leftList.size() > leftPoint && rightList.size() > rightPoint){
                if(leftList.get(leftPoint) > rightList.get(rightPoint)){
                    mergedList.add(rightList.get(rightPoint));
                    rightPoint +=1;
                } else{
                    mergedList.add(leftList.get(leftPoint));
                    leftPoint+=1;
                }
            }

            //case2: right데이터가 없을때
            while(leftList.size() > leftPoint){
                mergedList.add(leftList.get(leftPoint));
                leftPoint+=1;
            }

            //case3: left데이터가 없을때
            while(rightList.size()> rightPoint){
                mergedList.add(rightList.get(rightPoint));
                rightPoint+=1;
            }
            return mergedList;
        }
    }

}
