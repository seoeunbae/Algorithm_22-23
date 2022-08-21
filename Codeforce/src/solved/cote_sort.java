package solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class cote_sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer integer = scanner.nextInt();
        Func(integer);
    }

    public static void Func(Integer integer){
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<integer-1;i++){
           list.add(scanner.nextInt());
        }

        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
