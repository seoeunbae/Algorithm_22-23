package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        List<Integer> integers = new ArrayList<>();
        HashMap<Integer, Integer> rankingMap = new HashMap<>();

        String[] readline = buffer.readLine().split(" ");
        for(int i=0;i<readline.length;i++){
            int integer = Integer.parseInt(readline[i]);
            integers.add(integer);
        }

        for(int i=0 ; i < n ; i++){

        }
        Func(n,integers);
    }

    public static void Func(int n , List<Integer> integers){
        List<Integer> order = new ArrayList<>();
        HashMap<Integer, Integer> orders = new HashMap<>();

        Collections.sort(integers);

        int i =0;
        if(!orders.containsKey(integers.get(i))){
            orders.put(integers.get(i), i);
            i++;
        }//containskey로 중복

        for(int j=0;j< orders.size();j++){
            System.out.println(orders.get(j));
        }
    }
}
