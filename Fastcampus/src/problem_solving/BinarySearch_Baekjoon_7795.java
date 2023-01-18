package problem_solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BinarySearch_Baekjoon_7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        for(int i=0  ; i< T ; i++){
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);

            String[] s1 = br.readLine().split(" ");
            int[] A = Arrays.stream(s1).mapToInt(Integer::parseInt).toArray();
            String[] s2 = br.readLine().split(" ");
            int[] B = Arrays.stream(s2).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(A);
            Arrays.sort(B);

            int result = 0;

            for(int j=0 ; j< A.length ; j++){

                int count = 0;
                int std = A[j];

                for(int z=B.length-1 ; z >= 0 ; z--){
//                    System.out.println("std : "+std);
                    if(std > B[z]) {
                        count += z+1;
                        z = -1;
                    }
                    result+=count;
                }
//                result += count;
            }
            System.out.println(result);
        }

    }

    public static void solution(int num){

    }
}
