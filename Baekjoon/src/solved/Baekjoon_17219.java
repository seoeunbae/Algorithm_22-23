package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Baekjoon_17219 {

    static Map<String, String> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for(int i=0;i<n;i++){
            String[] splits = br.readLine().split(" ");
            Func(splits[0], splits[1]);
        }
        for(int i=0;i<m;i++){
            String s1 = br.readLine();
            Answer(s1);
        }
    }

    public static void Func(String site, String password){
        map.put(site,password);

    }

    public static void Answer(String s1){
        System.out.println(map.get(s1));
    }
}
