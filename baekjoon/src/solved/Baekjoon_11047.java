package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_11047 {
    static int[] priceRange;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        priceRange = new int[N];

        for(int i=0 ; i < N ; i++){
            priceRange[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        for(int i=N-1; i>=0 ; i--){
                if(priceRange[i] <= K) {
                    int biggest = priceRange[i];
                    count += K / biggest;
                    K = K % biggest;
                }
            }
        System.out.println(count);
    }


}
