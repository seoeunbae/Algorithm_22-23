package solved;

import java.util.Scanner;

public class Magnets {
    static int[] array;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        array = new int[num+1];
        for(int i=1 ; i< array.length ; i++){
            array[i] = scanner.nextInt();
        }
        System.out.println(Func(array));
    }

    public static Integer Func(int[] array){
        int pre = array[1];
        int group = 1;
        for(int i=2 ; i < array.length; i++){
            if(pre!=array[i]) {
                group++;
                pre = array[i];
            } else pre = array[i];
        }
        return group;
    }
}
