package solved;

import java.util.Scanner;

public class WordCapitalization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        System.out.println(Func(word));
    }

    public static String Func(String word){
        String[] split = word.split("");
        split[0] = split[0].toUpperCase();
        String result = "";
        for(String string: split){
            result = result.concat(string);
        }

        return result;
    }
}
//시간복잡도: O(word의 낱말개수)
//주제: 구현,스트링