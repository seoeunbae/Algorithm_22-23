package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UDLR {
    static ArrayList<String> route = new ArrayList<>();
    static Integer N;
    static int[] R = new int[]{0, 1};
    static int[] L = new int[]{0, -1};
    static int[] U = new int[]{-1, 0};
    static int[] D = new int[]{1, 0};

    static int tempX = 0;
    static int tempY = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            route.add(st.nextToken());
        }

        func();

    }

    public static void func(){
        int x =1;
        int y = 1;


        while( route.size() > 0){
            String s = route.get(0);
            route.remove(0);


            switch (s) {
                case "R":
                    tempX = x+ R[0];
                     tempY = y+ R[1];
                    break;
                case "L":
                     tempX = x+ L[0];
                     tempY = y+ L[1];
                    break;
                case "U":
                     tempX = x+ U[0];
                     tempY = y+ U[1];
                    break;
                default:
                     tempX = x+ D[0];
                     tempY = y+ D[1];
                    break;
            }

            if( tempX >= 1 && tempX <= N && tempY >= 1 && tempY<= N ){
                x = tempX;
                y = tempY;
            }

        }
        System.out.println((x) + " " + (y));
    }
}
