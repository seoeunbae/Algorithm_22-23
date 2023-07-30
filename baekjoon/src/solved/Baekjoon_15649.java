package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_15649 {
    static int[] numbers;
    static int N,M;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        permutation(M);
    }

    public static void permutation(int M){

    }
//    public static void permutation( int M ){
//        if(M == 0) {
//            for(int i=0 ; i<result.length ; i++){
//                System.out.println(result[i]+" ");
//            }
//            System.out.println();
//        }else{
//            for(int i=0 ; i < N ; i++){
//                if( !visited[i] ){
//                    visited[i] = true;
//                    result[M]= numbers[i];
//                    permutation(M+1);
//
//                    visited[i] = false;
//                }
//            }
//        }
//
//
//
//    }
}
