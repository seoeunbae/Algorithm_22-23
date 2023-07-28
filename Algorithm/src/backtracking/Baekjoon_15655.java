package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Baekjoon_15655 {
	static int[] temp;
	static int N;
	static int M;
	static StringTokenizer st;
	static boolean[] visited;
	static int[] array;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		array = new int[N];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i < N ; i++) {
			 array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
        temp = new int[M];
		permutation(0,0, temp);		
	}
	
	public static void permutation(int prev, int level, int[] temp) {
		if(level == M) {
			for(int elem : temp) {
				System.out.print(elem+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=prev ; i < N ; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[level] = array[i]; 
				permutation(i, level+1,temp);
				visited[i] = false;
			} 
		}
	}
	
}

