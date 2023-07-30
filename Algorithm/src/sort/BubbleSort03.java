package sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

//데이터가 네개일때 버블정렬알고리즘방식으로 정렬하는 방법에 대해 생각해보며,
//데이터갯수에 상관없ㅇ이 동작하는 버블 정렬알고리즘 생각해보기
public class BubbleSort03 {
    //버블정렬
    //시간복잡도: O(n^2)
    //최악의경우: n*(n-1)/2
    //최선의경우: O(n)
    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        for(int index = 0; index< dataList.size()-1; index++){ //데이터리스트들 여러개 반복 (dataList의 개수만큼)스왑
            boolean swap = false;

            for(int index2 = 0; index2< dataList.size()-1-index;index2++){//하나의 리스트안에서 2개씩 비교를 하는 반복문
                if(dataList.get(index2)> dataList.get(index2+1)){
                    Collections.swap(dataList, index2, index2+1);
                    swap = true;
                }
            }

            if(swap == false){
                break;
            }
        }

        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for(int i =0;i< 100;i++){
            testData.add((int)(Math.random()*100));
        }
        BubbleSort03 bSort = new BubbleSort03();
        System.out.println(bSort.sort(testData));
    }
}
