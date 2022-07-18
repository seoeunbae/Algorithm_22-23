package unsolved;

import java.util.*;

public class Baekjoon2178 {
    static int n;
    static int m;
    static int[][] maze;
    static int[] dx = new int[] {1,0,-1,0};
    static int[] dy = new int[] {0,1,0,-1};

    public static void main(String[] args) {
        maze = new int[101][101];
        Scanner scanner = new Scanner(System.in);
        String[] splits = scanner.nextLine().split(" ");
        n = Integer.parseInt(splits[0]);
        m = Integer.parseInt(splits[1]);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                maze[i][j] = scanner.nextInt();

            }
        }
        bfs();

    }

    public static void bfs(){
        List<int[]> need_visit = new ArrayList<>();
        List<int[]> visited = new ArrayList<>();

        need_visit.add(new int[]{1, 1});

        int count = 1;
        while(!need_visit.isEmpty()){
            visited.add(need_visit.get(0));
            int x = need_visit.get(0)[0];
            int y = need_visit.get(0)[0];
            need_visit.remove(0);
            for(int i = 0 ; i<4 ; i++){
                int next_x = x+dx[i];
                int next_y = y+dy[i];
                if(maze[next_x][next_y] == 1 && !visited.contains(new int[]{next_x, next_y})){
                    need_visit.add(new int[]{next_x, next_y});
                    count+=1;
                }
            }


        }
    }


}
