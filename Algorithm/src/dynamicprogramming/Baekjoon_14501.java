package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baekjoon_14501 {
    static int[] D;
    static ArrayList<Task> tasks = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.parseInt(br.readLine());
        D = new int[N+1];
        for(int i = 0 ; i < N ; i++){
            char[] chars = br.readLine().toCharArray();
            int T = (int) chars[0];
            int P = (int) chars[1];

            Task task = new Task(i+1,T, P);
            tasks.add(task);
        }

        for(int i= N ; i >= 1 ;i--){
            if(i + tasks.get(i-1).T > N) continue;
            D[i] = Math.max(D[i+1], tasks.get(tasks.get(i-1).completeDay).P + tasks.get(i-1).P);
        }
        System.out.println(D[1]);

    }

    public static class Task{
        int T;
        int P;

        int day;
        int completeDay;
        Task(int day,int T, int P){
            this.day = day;
            this.T = T;
            this.P = P;
            this.completeDay = this.day+this.T;
        }

        public int getP (){
            return this.P;
        }
    }
}
