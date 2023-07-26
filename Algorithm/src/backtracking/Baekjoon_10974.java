package backtracking;

import java.util.*;
import java.io.*;


public class Baekjoon_10974 {
	static boolean[] visited;
	static int[] array ;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		array = new int[N];
		
		for(int i=0 ; i < array.length ;i++) {
			array[i] = i+1;
		}
		
		permutation(new ArrayList<Integer>(), N);
	}
	
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	
	public static void permutation( ArrayList<Integer> current, int N) {
		if(current.size() == N) {
			for(Integer each : current) {
				System.out.print(each);
			}
			System.out.println();
			return;
		}
		
		for(int j=0 ; j < N ; j++) {
			if (visited[j]) continue;
			visited[j] = true;
			current.add(array[j]);
			permutation(current, N);
		//	current.remove(j);
			visited[j] = false;
		}
	}
	
	
}
