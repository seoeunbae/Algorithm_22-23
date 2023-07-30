package solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HelpfulMath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        System.out.println(Func(operation));
    }
    public static String Func(String operation){
        String[] splits = operation.split("\\+");
        List<Integer> integers = new ArrayList<>();
        for(int i=0 ; i < splits.length ; i++){
            integers.add(Integer.valueOf(splits[i]));
        }
        Collections.sort(integers);
        String result = integers.get(0).toString();
        for(int i=1;i<integers.size();i++){
            String integer = integers.get(i).toString();
            result = result.concat("+"+integer);
        }
        return result;
    }
}
