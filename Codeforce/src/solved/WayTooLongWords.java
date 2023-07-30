package solved;

import java.util.Scanner;

public class WayTooLongWords {
    public static String abbreviationFunc(String word){
        if(word.length()<=10){

            return word;
        }
        char[] chars = word.toCharArray();
        int count=0;
        for(int i =1;i<chars.length-1;i++){
            count++;
        }
        String stringCount = String.valueOf(count);
        String abbreviation = chars[0] + stringCount + chars[chars.length-1];
        return abbreviation;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for(int i=0; i< count;i++){

            System.out.println(abbreviationFunc(scanner.next()));
        }

    }
}
