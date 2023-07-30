package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Baekjoon_7785 {
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            Func(br.readLine().split(" "));
        }
        Iterator<String> iterator = set.iterator();
        List<String> list = new ArrayList<>();
        for (Iterator<String> it = iterator; it.hasNext(); ) {
            String string = it.next();
            list.add(string);
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public static void Func(String[] splits){
        String name = splits[0];
        String ox = splits[1];

        if(ox.equals("enter")){
            set.add(name);
        }
        if(ox.equals("leave")){
            set.remove(name);
        }


    }
}
