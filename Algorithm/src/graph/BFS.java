package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BFS {//2개의 큐(방문된 노드, 탐색이 필요한 노드)
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));
        BFSFunc("A", graph);

    }
//큐는 어레이리스트로 구현가능했었다.(add,remove,addAll 사용)
    public static void BFSFunc(String first, HashMap<String, ArrayList<String>> graph){
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> need_visit = new ArrayList<>();
        need_visit.add(first);
        int count = 0;
        while(need_visit.size()>0){
            count +=1;
            if(visited.contains(need_visit.get(0))){
                need_visit.remove(0);
                continue;
            } else {
                visited.add(need_visit.get(0));//방문
                need_visit.addAll(graph.get(need_visit.get(0)));//연결노드 방문필요큐에 넣기
                need_visit.remove(0);//하나씩 앞당기기
            }
        }
        System.out.println(visited);
    }
}
//시간복잡도: O(N+V) 노드수+간선수
