package solved;

import java.util.Scanner;

public class Elephant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer distance = Integer.valueOf(scanner.nextLine());
        System.out.println(Func(distance));

    }

    public static Integer Func(Integer distance){
        int step = distance/5;
        if(distance % 5 == 0 ){
            return step;
        } else return step+1;
    }

}
