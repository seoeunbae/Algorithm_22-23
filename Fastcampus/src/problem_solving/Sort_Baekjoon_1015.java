package problem_solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Sort_Baekjoon_1015 {
    static int[] A;

    static class Elem{
        int idx;
        int num;
    }
    static int[] P;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer number = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        P = new int[number];
        int[] B = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        A = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();//A
        Arrays.sort(B);//A1
        solution(B);
//2131
        //1123
        //203

    }

    public static void solution(int[] B ){
        for(int i=0 ; i < A.length ; i++){
            int element = A[i];
            for(int j=0 ; j < B.length ; j++){
                if(B[j] == element) {
                    System.out.print(j+" ");

                    B[j]= 1001;
                    j=B.length;
                }//1113()466 //41613614
            }
        }
    }
}
