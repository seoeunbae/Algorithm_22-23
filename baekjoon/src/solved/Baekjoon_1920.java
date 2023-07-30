package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        Integer M = Integer.valueOf(br.readLine());
        String[] s1 = br.readLine().split(" ");
        List<Integer> integers = new ArrayList<>();
        for(int i=0;i<s.length;i++){
            integers.add(Integer.parseInt(s[i]));
        }
        Collections.sort(integers);
        for(int i=0;i<M;i++){
            Integer key = Integer.parseInt(s1[i]);
            Func(integers,key);
        }
    }

    public static void Func(List<Integer> s, Integer s1i){

        System.out.println(binearySearch(s, s1i,0,s.size()-1));


    }

    public static int binearySearch(List<Integer> integers,int key, int low, int high){
        int mid;

        while(low<=high){
            mid = (low+high)/2;

            if(key == integers.get(mid)){
                return 1;
            } else if(key < integers.get(mid)){
                 high = mid-1;
            } else {
                 low = mid +1;
            }
        }
        return 0;
    }
}
