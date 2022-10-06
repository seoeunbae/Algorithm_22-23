package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers202202 {
    static String[][] stringMaps;
    static int[] dx = {-1, 1 , 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static HashMap<String, Integer> count = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        System.out.println(Func(s));
    }

    public static Integer Func(String[] maps){
        stringMaps = new String[maps.length][maps[0].length()];
        for(int i=0 ; i< maps.length ; i++){
            for(int j=0; j<maps[i].length() ; j++){
                stringMaps[i][j]=maps[i].split("")[j];
            }
        }

        return bfs(0,0, stringMaps);
    }

    public static Integer bfs(int x, int y, String[][] maps){
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        for(boolean[] bool : visited){
            for(boolean boolI : bool){
                boolI = false;
            }
        }
        Queue<int[]> queue =new LinkedList<>();

        queue.add(new int[] {x,y});
        count.put(maps[x][y], count.getOrDefault(maps[x][y], 1)+1);
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            visited[poll[0]][poll[1]] = true;
            for(int i=0 ; i<4 ; i++){
                int ax = dx[i] + poll[0];
                int ay = dy[i] + poll[1];
                if( ax<0 || ay < 0 || ax>= maps[0].length || ay>= maps.length ||maps[ax][ay].equals(".") ||visited[ax][ay]){
                    continue;
                }

            }
        }

        return count.values().stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        }).get();
    }
}
