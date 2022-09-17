package solved;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicReference;

public class Baekjoon_5052 {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine())     ;

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            String[] phoneNumber = new String[N];

            for(int i=0 ; i<N;i++){
                phoneNumber[i] = br.readLine();
            }

            Arrays.sort(phoneNumber);

            if(isConsistent(N,phoneNumber)){
                bw.write("YES\n");
            } else{
                bw.write("NO\n")
            }
    }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isConsistent(int N , String[] photoNumber){
        for(int i=0; i< N-1 ; i++){
            if(photoNumber[i+1].startsWith(photoNumber[i])){
                return false;
            }
        }
        return true;
    }

}
