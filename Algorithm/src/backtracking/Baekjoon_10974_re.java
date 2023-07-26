package backtracking;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class Baekjoon_10974_re {

	static boolean[] visited;
	static int[] array ;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer N = Integer.parseInt(br.readLine());
		array= new int[N];
		visited = new boolean[N];
		for(int i=0 ; i < N ; i++) {
			array[i]= i+1;
		}
		
		int[] output = new int[N];
		permutations(output, 0, N);
		
	}
	
	public static void permutations(int[] output, int index, Integer N) {
		if(index == N) {
			for(int i=0 ; i < output.length ; i++) {
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0 ; i < N ; i++) {
			if (visited[i] ) continue;
			visited[i] = true;
			output[index] = array[i];
			permutations(output, index+1, N);
			visited[i] = false;
		}
	}

}
