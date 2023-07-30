package solved;

import javax.crypto.spec.PBEKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2667 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] town;
    static int num;
    static boolean[][] visited;
    static int count;
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        town = new int[num][num];
        visited = new boolean[num][num];

        for(int i=0; i<num ; i++){
            String[] splits = br.readLine().split("");
            for(int j=0 ; j < num ; j++){
                town[i][j] = Integer.parseInt(splits[j]);
                visited[i][j]=false;
            }
        }

        for(int i=0;i<num;i++){
            for(int j =0;j<num;j++){
                if(town[i][j]==1 && !visited[i][j]) {
                    count=1;
                    dfs(i,j);
                    result.add(count);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int h=0 ; h < result.size() ; h++){
            System.out.println( result.get(h));
        }
    }

    public static Integer dfs(int x, int y ){
        visited[x][y] = true;
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y + dy[i];

            if(nx >=0 && ny >= 0 && nx < num && ny < num){
                if( town[nx][ny]==1 && !visited[nx][ny]){
                    dfs(nx, ny);
                    count++;
                }
            }

        }
        return count;
    }
}
