package solved;

import java.util.*;

public class kabank03 {
    static List<List<Integer>> array;
    static int[] indegree;



    public static void main(int[] rooms) {
        array = new ArrayList();
        indegree= new int[rooms.length];

        for(int i = 0 ; i < rooms.length ; i++){
            List<Integer> key = new ArrayList<>();
            key.add(rooms[i]);

            array.add(key);
            indegree[rooms[i]]++;
        }

    }

    public static Integer Func(){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> result= new TreeSet<>();
        boolean[] visited = new boolean[indegree.length];

        for(int i=0 ; i < indegree.length-1 ; i++){
            if(indegree[i] == 0){
                visited[i] = true;
                queue.offer(i);
            }
        }
        int count = 0;

        while(!queue.isEmpty()){

            int node = queue.poll();
            //답관련 처리
            for(int i : array.get(node)){
                indegree[i]--;

                if(indegree[i] == 0){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        for(boolean visit : visited){
            if(!visit) count++;
        }

        return count;
    }
}
