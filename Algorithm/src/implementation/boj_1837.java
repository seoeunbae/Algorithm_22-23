package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class boj_1837 {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        BigInteger p = new BigInteger(s[0]);
        int k = Integer.parseInt(s[1]);
        for(int i = k ; i > 0 ;i++){
            if (isPrime(i)) {
                if (p.remainder(i).compareTo(BigInteger.ZERO) == 0) {
                    System.out.println("BAD " + i);
                    return;
                }
            }
        }
        System.out.println("GOOD");
    }

    public static boolean isPrime(int x){
        for(int i=2 ; i < Math.sqrt(x) ; i++){
            if (x % i == 0) return false;
        }
        return true;
    }
}
