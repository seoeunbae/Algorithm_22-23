package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlusOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int[] digits = new int[s.length];
        for(int i=0;i<s.length;i++){
            digits[i] = Integer.parseInt(s[i]);
        }
        System.out.println(plusOne(digits));
    }
    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1 ; i >= 0 ; i--) {
            digits[i]++;

            if (digits[i] < 10) {
                return digits;
            }

            digits[i] = 0;
        }

        int[] res = new int[n + 1];
        res[0] = 1;
        return res;

    }
}
