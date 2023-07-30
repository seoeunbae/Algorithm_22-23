package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2747 {
    static Integer[] fibonacciArray;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        fibonacciArray  = new Integer[n+1];
        System.out.println(fibonacci(n));
        System.out.println(fibonacciArray[n]);
    }

    public static Integer fibonacci(int n){
        if( n== 0 ){
            fibonacciArray[n] = 0;
            return 0;
        }
        else if (n == 1){
            fibonacciArray[n] = 1;
            return 1;
        }
        else if(fibonacciArray[n]!= null){
            return fibonacciArray[n];
        }
        else {
           return fibonacciArray[n] = fibonacci(n-1) + fibonacci(n-2);
        }

    }
}
