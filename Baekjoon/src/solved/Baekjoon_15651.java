package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon_15651 {

//    static List<ArrayList<Integer>> list = new ArrayList<>();
    static int N, M;
    static int[] selected;

    static StringBuilder sb = new StringBuilder();

//    static List<Integer> chosenNums = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]); //3
        M = Integer.parseInt(s[1]); //1 // level
        selected = new int[N+1]; //0~N

        permutation(1);
        System.out.println(sb.toString());
    }

    public static void permutation(int k){ //m: 1->0
        if( k == M+1 ){// end
            for( int i=1 ; i<M ; i++){
//                sb.append(selected[i]).append(" ");
                System.out.println(selected[i]);
            }
//            sb.append("\n");
        } else { //m != 0 && singleResult 횟수 부족한 경우
            for(int cand=1 ; cand <= N ; cand++ ){ //1,2,3
                selected[k] = cand;
                permutation(k+1);
                selected[k] = 0;
            }
        }

    }
}
