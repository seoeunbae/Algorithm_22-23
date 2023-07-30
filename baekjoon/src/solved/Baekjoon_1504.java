//package solved;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Baekjoon_1504 {
//
//    static int N;
//    static int E;
//
////    static int a;
////    static int b;
////    static int c;
//
//    static int v;
//    static int u;
//
//    static Queue<Integer> queue = new LinkedList<>();
//    static ArrayList<Vertex>[] shortestPath;
////    static boolean[] visited;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] s = br.readLine().split(" ");
//        N = Integer.parseInt(s[0]);
//        E = Integer.parseInt(s[1]);
////        visited = new boolean[N+1];
//        shortestPath = new ArrayList[N+1];
//
//        for(int i=0 ; i < E ; i++){
//            String[] s1 = br.readLine().split(" ");
//            Integer a = Integer.parseInt(s1[0]);
//            Integer b =Integer.parseInt(s1[1]);
//            Integer c = Integer.parseInt(s1[2]);
//
//            shortestPath[a]=new ArrayList<>();
//            Vertex vertex = new Vertex(b,c);
//            shortestPath[a].add(vertex);
//
//            shortestPath[b]=new ArrayList<>();
//            Vertex vertex1 = new Vertex(a,c);
//            shortestPath[b].add(vertex1);
//            //초기화
//        }
//        String[] s1 = br.readLine().split(" ");
//
//        Integer u = Integer.parseInt(s1[0]);
//        Integer v = Integer.parseInt(s1[1]);
//
//        bfs(1, u, v);
//
//
//    }
//
//    public static void bfs(int start, int u ,int v){
//        queue.add(start);
////        visited[start]= true;
//
//        while(!queue.isEmpty()){
//            Integer poll = queue.poll();
////            visited[poll] = true;
////            Vertex min = shortestPath[poll].stream().min(new Comparator<Vertex>() {
////                @Override
////                public int compare(Vertex o1, Vertex o2) {
////                    return o2.distance - o1.distance;
////                }
////            }).get();
//            shortestPath[poll]
//            queue.add(poll);
//        }
//
//    }
//
//    public static class Vertex {
//        int distance;
//        int target;
//        public Vertex(int distance, int target){
//            this.distance = distance;
//            this.target = target;
//        }
//    }
//}
