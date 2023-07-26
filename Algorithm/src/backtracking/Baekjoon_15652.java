package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_15652 {
	static int N;
	static int M;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		permutation(1,0, new int[M]);
		System.out.println(sb.toString());
		
	}
	
	public static void permutation(int prevIdx, int level , int[] array) {
		if (level == M) {
			for(int each : array) {
				System.out.print(each+" ");
			}
			System.out.println();
			return;
		}
		for(int i = prevIdx ; i <= N ; i++) {
			array[level] = i;
			prevIdx = i;
			permutation(prevIdx, level+1, array);
		}
	}

}
