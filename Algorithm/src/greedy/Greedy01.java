package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Greedy01 {
    public static void coinFunc(Integer price , ArrayList<Integer> coinList){
        Integer totalCount = 0;
        Integer coinNum = 0;
        ArrayList<Integer> details = new ArrayList<>();

        for(int index = 0 ; index< coinList.size(); index++){
            coinNum = price/coinList.get(index);
            totalCount += coinNum;
            price -=coinNum * coinList.get(index);
            details.add(coinNum);
            System.out.println(coinList.get(index) + "원: "+ coinNum + " 개");
        }
        System.out.println("총 동전 갯수: "+ totalCount);
    }

    public static void main(String[] args) {
        ArrayList<Integer> coinList = new ArrayList<>(Arrays.asList(50,100,500));
        coinFunc(4720, coinList);
    }
}
