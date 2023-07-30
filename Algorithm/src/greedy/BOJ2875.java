package greedy;

import java.util.Scanner;

public class BOJ2875 {

    public static Integer greedyFunc(Integer N, Integer M, Integer K){
        if((N-2)/2 >= (M-2)){
            return (N-2)/2;
        }else {
            return N/2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Integer N = scanner.nextInt();
        Integer M = scanner.nextInt();
        Integer K = scanner.nextInt();
        int count = 0;

        while(N>=2 && M>=1 && M+N-K>3){
            N-=2;
            M-=1;
            count++;
        }
        System.out.println(greedyFunc(N,M,K));

    }
}
