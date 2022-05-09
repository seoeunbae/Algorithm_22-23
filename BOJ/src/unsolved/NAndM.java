package unsolved;

import java.util.Scanner;

public class NAndM {
    public static int N;
    public static int M;
    public static int[] selected;
    public static StringBuilder result;
    public static void rec_func(int k){
        if(k==M+1){
            //selected[1,...M] 배열이 새롭게 탐색된 결과
            for(int i=1; i<=M; i++){
                result
                        .append(selected[i])
                        .append(' ');
            }
            result.append("\n");
        }else{
            //1~N까지를 k번 원소로 한 번씩 정하고,.
            //매번 k+1번부 M번 원소로 재귀호출해주기
            for(int cand =1; cand<=N;cand++){
                selected[k] = cand;
                //k+1번~M번 을 모두 탐색해야하는 일을 해야하는 상황
                rec_func(k+1);
                selected[k]=0;
            }
        }
    }
    static void setInput(){
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        selected = new int[M+1];
    }

    public static void makeResult(){
        setInput();
        rec_func(1);
        System.out.println(result.toString());
    }

}

//시간복잡도 = O(N^M)
//공간복잡도 = O(M)
