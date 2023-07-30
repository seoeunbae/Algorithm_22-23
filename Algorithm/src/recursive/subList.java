package recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subList {
    public static class Factorial{
        int sum =0;
        public int factorialFunc(List<Integer> dataList){
            if(dataList.size() <= 0){
                return 0;
            } else {
                sum+=dataList.get(0);
//                System.out.println(dataList.get(0) + factorialFunc(dataList.subList(1,dataList.size())));
                return dataList.get(0) + factorialFunc(dataList.subList(1,dataList.size()));


            }
        }
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.factorialFunc(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5))));
    }
}
