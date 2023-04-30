

import java.util.*;

public class WithTaxiDistance {
    static ArrayList<ArrayList<Node>> board = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;
    static int[] withDistance;


    public class Node{
        int node;
        int edge;

        Node(int node, int edge){
            this.node = node;
            this.edge = edge;
        }

        @Override
        public boolean equals(Object o){
            int object = (int)o;
            return object == this.node;
        }

        @Override
        public int hashCode(){
            return Objects.hash(this.node);
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        distance = new int[n+1];
        visited = new boolean[n+1];
        withDistance = new int[n+1];

        for(int i=0 ; i <= n ; i++){
            board.add(new ArrayList<Node>());
        }
        for(int i=0 ; i < fares.length ; i++){
            int n1 = fares[i][0];
            int n2 = fares[i][1];
            int n3 = fares[i][2];

            board.get(n1).add(new Node(n2, n3));
            board.get(n2).add(new Node(n1, n3));

        }

        return dijkstra(s , n ,a,b);

    }

    public Integer dijkstra(int start, int n ,int a, int b){
        PriorityQueue<Node> pq = new PriorityQueue<Node>(Comparator.comparingInt(o -> o.edge));
        //무한대로 초기화
        for(int i = 0 ; i <= n ; i++){
            distance[i] = (int) 1e9;
        }
        //시작점 0으로 설정
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){

            Node poll = pq.poll();
            int index = poll.node;
            int weight = poll.edge;
            if(visited[index]) continue;
            visited[index] = true;

            for(Node node : board.get(index)){
                int cost = node.edge + distance[index];
                if(cost < distance[node.node]){
                    distance[node.node] = cost;
                    withDistance[node.node] = cost/2;
                    pq.add(new Node(node.node, distance[node.node]));
                }

            }
        }

        int answer = 0;
        for(int i=0 ; i <= n ; i++){
            Integer i1 = board.get(i).indexOf((int)a);
            Integer i2 = board.get(i).indexOf((int)b);
            if(i1 == null || i2 == null) continue;
            int withCost = distance[i]/2 + board.get(i).get(i1).edge+ board.get(i).get(i2).edge;
            if(withCost < distance[a] + distance[b]){
                answer = withCost;
            }

        }
        return answer;
    }
}