package solved;

import java.util.Arrays;
import java.util.Scanner;

public class UpperCaseLowerCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Func(scanner.nextLine());
    }

    public static void Func(String string){
        char[] splits = string.toCharArray();
        for(int i=0;i<splits.length;i++){
            if( 65<=  splits[i] && splits[i]<=90){
                splits[i]= (char) (splits[i]-32);
                System.out.println(splits[i]);
            } else{
                splits[i] = (char) (splits[i]+32);
                System.out.println(splits[i]);
            }

        }

        System.out.println(Arrays.toString(splits));
    }
}
