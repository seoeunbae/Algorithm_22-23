package solved;

import java.util.*;

public class Beakjoon_1427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split("");
        Func(split);
    }

    public static void Func(String[] split){
        List<Integer> integers= new ArrayList<>();
        for(int i=0;i<split.length;i++){
            Integer integer = Integer.valueOf(split[i]);
            integers.add(integer);
        }

        Collections.sort(integers, new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i2-i1;
            }
        });

        for(int i=0;i<integers.size();i++){
            System.out.print(integers.get(i));
        }


    }
}
