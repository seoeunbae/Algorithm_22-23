package solved;

import java.util.Scanner;

public class AntonAndDanik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer numberOfPlay = Integer.valueOf(scanner.nextLine());
        String winners = scanner.nextLine();
        System.out.println(Func(numberOfPlay, winners));
    }

    public static String Func(Integer numberOfPlay, String winners){
        int count = 0;
        char[] winnerChars = winners.toCharArray();
        for(char winnerChar: winnerChars){
            if( winnerChar == 'A'){
                count++;
            }else count--;
        }
        if(count==0) return "Friendship";
        else if( count > 0) return "Anton";
        else return "Danik";
    }

}
//시간복잡도: O(n)
//구현