package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon_15650 {
	static int N;
	static int M;
	static ArrayList<int[]> totalList = new ArrayList<>();
	static HashSet<Integer> used = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] array = new int[M];
		permutation(1, 0, array);
		
		
	}
	
	public static void permutation(int prevIdx, int level, int[] array) {
		if (level == M) {
//			totalList.add(array);
			for(int each : array) {
				System.out.print(each+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i=prevIdx; i<= N ; i++) {
			if (used.contains(i)){
				continue;
			}
			used.add(i);
			array[level]=i;
			prevIdx = i;
			permutation(prevIdx, level+1, array);
			used.remove(i);
		}
	}
}
