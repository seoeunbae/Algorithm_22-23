package solved;

import java.io.IOException;
import java.util.Scanner;

public class Baekjoon_9742 {
    static String[] inputs;
    static Integer order;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String[] s = scanner.nextLine().split(" ");
            inputs = s[0].split("");
            order = Integer.parseInt(s[1]);

            dfs(inputs, order);
        }

    }

    public static void dfs(String[] inputs ,int order){

    }
}
