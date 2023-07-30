package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_12891 {
    static int P;
    static int S;
    static int[] ACGT;
    static String[] DnaSplit;
    static int[] eachACGT;

    static int result = 0;

    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(" ");
        S = Integer.parseInt(string[0]);
        P = Integer.parseInt(string[1]);

        DnaSplit = br.readLine().split("");

        String[] ACGTs = br.readLine().split(" ");
        ACGT = Arrays.stream(ACGTs).mapToInt(Integer::parseInt).toArray();

        solution(ACGT, DnaSplit);
    }

    public static void solution(int[] ACGT, String[] DnaSplit){
        //투포인터
        //슬라이딩 윈도우 원리
        eachACGT = new int[4];

        for(int i=0 ; i<P ; i++){
            add(DnaSplit[i]);
        }

        if(checkSecret == 4) result++;


        for(int i=P ; i<S ; i++){
            int j = i - P;
            add(DnaSplit[i]);
            remove(DnaSplit[j]);
            System.out.println(checkSecret);
            if(checkSecret == 4) result++;

        }
        System.out.println(result);

    }

    public static void remove(String each){
        switch (each){
            case "A":
                if(eachACGT[0]==ACGT[0]) checkSecret--;
                eachACGT[0]--;

                break;
            case "C":
                if(eachACGT[1]==ACGT[1]) checkSecret--;
                eachACGT[1]--;

                break;
            case "G":
                if(eachACGT[1]==ACGT[1]) checkSecret--;
                eachACGT[2]--;

                break;
            case "T":
                if(eachACGT[3]==ACGT[3]) checkSecret--;
                eachACGT[3]--;

                break;
        }
    }

    public static void add(String each){
        switch (each){
            case "A":
                eachACGT[0]++;
                if(eachACGT[0]>=ACGT[0]) checkSecret++;
                break;
            case "C":
                eachACGT[1]++;
                if(eachACGT[1]>=ACGT[1]) checkSecret++;
                break;
            case "G":
                eachACGT[2]++;
                if(eachACGT[2]>=ACGT[2]) checkSecret++;
                break;
            case "T":
                eachACGT[3]++;
                if(eachACGT[3]>=ACGT[3]) checkSecret++;
                break;
        }
    }
}
