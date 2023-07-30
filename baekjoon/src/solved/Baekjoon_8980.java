package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Baekjoon_8980 {

    static int N;
    static int M;
    static int T;

    public static class Info {
        int from;
        int to;
        int kg;

        Info(int from, int to, int kg){
            this.from = from;
            this.to = to;
            this.kg = kg;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        T = Integer.parseInt(s[1]);

        M = Integer.parseInt(br.readLine());

        ArrayList<Info> infos = new ArrayList<>();

        for(int i=0 ; i < M ; i++){
            String[] s1 = br.readLine().split(" ");
            Info info = new Info(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]), Integer.parseInt(s1[2]));
            infos.add(info);

        }

        infos.sort(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.from == o2.from) {
                    return o2.to - o1.to;
                } else return o2.from - o1.from;
            }
        });

        System.out.println(infos.get(0) + " "+ infos.get(infos.size()-1));
        int memory = 0 ;

        for(int i=0 ; i < M ; i++){
            Info info = infos.get(i);
            if(T >= memory + info.kg){
                memory += info.kg;
            }
        }


    }


}
