package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_1717 {
    static int m,n;
    static int[] array; //0 ~ n

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        array = new int[n+1];

        for (int i=0 ; i< array.length ; i++){
            array[i] = i;
        }

        for (int i = 0 ; i < m ; i++){
            String[] s1 = br.readLine().split(" ");

            if(s1[0].equals("0")){
                union(Integer.parseInt(s1[1]), Integer.parseInt(s1[2]));

            } else {
                if(isEqual(Integer.parseInt(s1[1]), Integer.parseInt(s1[2]))) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
    public static int findParent(int max ){

        if(array[max] == max ) return array[max];
        else {
            return array[max] = findParent(array[max]);
        }

    }
    public static void union(Integer a, Integer b){
        a = findParent(a);
        b= findParent(b);
        if(!a.equals(b)){
            array[Math.max(a,b)] = Math.min(a,b);
        }

//        for(int i=0 ; i<array.length ; i++){
//            System.out.print(array[i]);
//        }
//        System.out.println();
    }

    public static boolean isEqual(Integer a, Integer b){
        a = findParent(a);
        b = findParent(b);
        if(a.equals(b)) return true;
        return false;
        //동일 비교할때도 findPArent를 활용해서 해줘야 함!
    }
}
