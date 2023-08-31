package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2748 {

	static BufferedReader in;
	static StringTokenizer st;
	static int[] memo ;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		memo = new int[n+1];
	}
	
	public static int fibo(int n) {
		if(n >=2 && memo[n] == 0) {
			memo[n] = fibo(n-1)+fibo(n-2);
		}
		
		return memo[n];
	}

}
