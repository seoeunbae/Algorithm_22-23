package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Baekjoon_2644 {
    static Stack<Integer> stack = new Stack<>();
    static Boolean[] visited;
    static ArrayList<Integer>[] relations;
    static int start;
    static int ans = -1;
    static int count =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());

        String[] s1 = br.readLine().split(" ");

        start = Integer.parseInt(s1[0]);
        Integer b = Integer.parseInt(s1[1]);

        Integer m = Integer.parseInt(br.readLine());

        visited = new Boolean[n+1];
        relations = new ArrayList[n+1];
        for(int i=0 ;i <= n ;i++){
            relations[i]= new ArrayList<>();
            visited[i] = false;
        }
        for(int i=0 ; i<m ;i++){
            String[] s = br.readLine().split(" ");

            int parent = Integer.parseInt(s[0]);
            int child = Integer.parseInt(s[1]);

            relations[parent].add(child);
            relations[child].add(parent);


        }

        System.out.println(dfs(start, b, count));

    }

    public static Integer dfs(int start, int target, int count){
        visited[start]=true;

            for(int i: relations[start]){
                if(!visited[i]){
                    if(i ==target){
                        ans = count+1;
                    }

                    dfs(i, target, count+1);
                }
            }
            return ans;
        }

    }

