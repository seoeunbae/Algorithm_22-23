package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Clock {

    static int count =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        func(N);
    }

    public static void func(int N){
        for(int i=0 ; i <= N ; i++){
            for (int j=0 ; j < 60 ; j++){
                for (int z=0 ; z < 60 ; z++){
                    if(is3Exist(i, j, z)) count++;
                }
            }
        }

        System.out.println(count);
    }

    public static boolean is3Exist(int h, int m , int s){
        if(h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3) {
            return true;
        }

        return false;
    }


}
