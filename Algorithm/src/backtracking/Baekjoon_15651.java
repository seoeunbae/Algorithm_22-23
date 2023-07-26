package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon_15651 {
	static int N;
	static int M;
	static HashSet<Integer> used = new HashSet<>();
	static ArrayList<int[]> totalList = new ArrayList<>();
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		permutation(0, new int[M]);
		System.out.println(sb.toString());
		
	}
	
	public static void permutation(int level, int[] array) {
		if (level == M) {
			for(int each : array) {
				sb.append(each).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i <= N ; i++) {
			array[level] = i;
			permutation(level+1, array);
		}
	}
}
