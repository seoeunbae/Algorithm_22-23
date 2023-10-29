package bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_B_n02 {
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine());

        for(int t = 1; t <= tc ; t++){
            String[] ins = in.readLine().split(" ");
            int n = Integer.parseInt(ins[0]);
            int m = Integer.parseInt(ins[1]);

            int x = (1<<(n))-1; //1...111 길이N인 이진수
            if(x == (m & x)){
                System.out.println("#" + t +" ON");
            } else {
                System.out.println("#" + t +" OFF");
            }
        }
    }
}
