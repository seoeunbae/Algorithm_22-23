package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Baekjoon_25538 {
    static int N;
    static int Q;

    static int[] members;

    static int[] union;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        Q = Integer.parseInt(s[1]);
        members = new int[N+1];
        union = new int[N+1];

        char[] charMembers = br.readLine().toCharArray();
        for(int i=0 ; i < charMembers.length ; i++){
            members[i] = (int) charMembers[i];
        }

        for(int i=0 ; i < charMembers.length ; i++){
            union[i] = i;
        }

        System.out.println(members[0]);

        for(int j=0 ; j < Q ; j++){
            String[] s1 = br.readLine().split(" ");
            int type = Integer.parseInt(s1[0]);
            int a = Integer.parseInt(s1[1]);
            int b = Integer.parseInt(s1[1]);

            switch (type){
                case 1:
                    members[a] += b;
                    break;
                case 2:
                    members[a] -= a;
                    break;
                case 3:
                    if(union[a] < union[b]){
                        union[b] = union[a];
                    } else union[a] = union[b];


//                    int temp = members[a];
//                    members[a] += members[b];
//                    members[b] += temp;
                    break;
                case 4:
                    int result = members[a] + members[b];
                    break;
            }


        }

    }
}
