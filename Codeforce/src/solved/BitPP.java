package solved;

import java.util.Arrays;
import java.util.Scanner;

public class BitPP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer LineCount = Integer.parseInt(scanner.nextLine());
        int x = 0;
        for( int index =0 ; index < LineCount ; index++){
            String[] splits = scanner.nextLine().split("X");
            if(Arrays.asList(splits).contains("++")){
                x++;
            } else x--;
        }
        System.out.println(x);

    }
}
//implementation