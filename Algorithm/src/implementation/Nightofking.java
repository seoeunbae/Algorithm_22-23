package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Nightofking {
    static int[] dx = {-2, -1, 2, 1, 1, 2, -2, -1};
    static int[] dy = {-1, -2, 1, 2, -2, -1, 1, 2};
    static ArrayList<String> list = new ArrayList<>(List.of("a", "b", "c" ,"d", "e", "f", "g", "h"));
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        String order = s[0];
        Integer r = list.indexOf(order);
        Integer l = Integer.parseInt(s[1])-1;
        func(r,l);

    }

    public static void func(int r, int l){
        for(int i = 0 ; i < dx.length ; i++){
            int ax = r + dx[i];
            int ay = l + dy[i];
            if(ax >= 0 && ax < 8 && ay >=0 && ay < 8 ){
                count++;
            }
        }

        System.out.println(count);
    }
}
