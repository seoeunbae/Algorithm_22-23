package problem_solving;

import java.util.LinkedList;
import java.util.Queue;

public class DFSBFS_Baekjoon_2251 {
    static int[] Limit = new int[3];

    public static void main(String[] args) {

    }

    public static void pro(){
        bfs(0, 0, Limit[2]);
    }

    public static void print(){

    }

    public static void input(){

    }

    public static class State{
        int[] liters;

        State(int[] liters){

            liters = new int[3];

            for( int i=0 ; i<3 ; i++) this.liters[i] = liters[i];

        }

        State move(int from, int to, int[] limit){
            int[] nX = new int[]{liters[0], liters[1], liters[2]};
            if( liters[from] + liters[to] >= limit[to] ) {
                limit[from] -= limit[to] - liters[to];
            }
            return new State(nX);
        }

    }

    public static void bfs(int x1, int x2, int x3){
        Queue<State> queue = new LinkedList<>();

    }
}
