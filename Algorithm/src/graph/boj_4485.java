package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_4485 {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] map;
	static int[][] distance;
	static int n;
	static StringBuilder sb;
	static int[] dy = {0,1,-1,0};
	static int[] dx = {1,0,0,-1};
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		n  = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		int order = 1;
		while(n != 0) {
			distance = new int[n][n];
			map = new int[n][n];
			sb.append("Problem ").append(order).append(": ");
			for(int i=0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0 ; j < n ; j++) {
					int k = Integer.parseInt(st.nextToken());
					map[i][j] = k;
				}
				
			}
			
			for(int i=0 ; i < n ; i++) {
				for(int j=0; j < n ; j++) {
					distance[i][j] = INF;
				}
			}
			sb.append(dijkstra() + "\n");
			n = Integer.parseInt(br.readLine());
			order++;
		}
 		
		System.out.println(sb.toString());
		br.close();
	}
	
	public static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		distance[0][0] = map[0][0];
		
		pq.add(new Node(0,0,map[0][0]));
	
		
		while(!pq.isEmpty()) {
			Node poll = pq.poll();
			for(int k=0 ; k < 4 ;k ++) {
				int row = poll.y +dy[k];
				int col = poll.x + dx[k];
				if(isValid(row, col)) {
					int dist = distance[poll.y][poll.x]+map[row][col];
					if(distance[row][col] > dist) {
						distance[row][col] = dist;
						pq.offer(new Node(row,col,dist));
					}
				}
			}
			
		}
		return distance[n-1][n-1];
	}
	
	public static class Node implements Comparable<Node>{
		int y;
		int x;
		int k;
		Node(int y, int x, int k){
			this.y=y;
			this.x = x;
			this.k=k;
		}
		@Override
		public int compareTo(Node o) {
			return this.k - o.k;
		}
		
		
	}
	
	public static boolean isValid(int x, int y) {
		return x>=0 && y>=0 && y <n && x <n;
	}
}
