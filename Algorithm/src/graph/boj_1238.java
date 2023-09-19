
package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1238 {
	static BufferedReader br;
	static StringTokenizer st;
	static ArrayList<Edge>[] list;
	static int[] distance;
	static int[] total;
	public static class Edge implements Comparable<Edge>{
		int to;
		int c; 
		Edge(int to, int c){
			this.to = to;
			this.c = c;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.c - o.c;
		}
		
	}
	
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		int n = Integer.parseInt(inputs[0]);
		list = new ArrayList[n+1];
		distance = new int[n+1];
		total = new int[n+1];
		for(int i=1 ; i <= n ; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i=1;  i <= n ; i++) {
			list[i] = new ArrayList();
		}
		//list초기화
		int m = Integer.parseInt(inputs[1]);
		int k = Integer.parseInt(inputs[2]);
		distance[k] = 0;
		for(int i=0 ; i < m ; i++) {
			st =  new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to =Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[from].add(new Edge(to,c));
		}
		
		dijkstra(k);
		for(int i=1 ; i <= n ; i++) {
			if(i != k) total[i] += distance[i];
		}
		//k에서 각 마을로 가는 최단경로 더하기
		

		
		for(int i=1 ; i <= n ; i++) {
			if(i != k) {
				for(int j=1 ; j <= n ; j++) {
					distance[j] = Integer.MAX_VALUE;
				}
				distance[i] = 0;
				dijkstra(i);
				total[i] += distance[k];
			}
		}
		int ans = 0;
		for(int i=1 ; i <= n ; i++){
			ans = Math.max(ans, total[i]);
		}
		System.out.println(ans);
	}
	
	public static void dijkstra(int x) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(x,0));
		
		while(!pq.isEmpty()) {
			Edge poll = pq.poll();
			if (distance[poll.to] < poll.c ) {			
				continue;
			}
			
			for(Edge edge : list[poll.to]) {
				if(distance[poll.to] + edge.c  <= distance[edge.to]) {
					distance[edge.to] = distance[poll.to] + edge.c;
					pq.offer(new Edge(edge.to, distance[edge.to]));
				}
			}
		}
	}


}
