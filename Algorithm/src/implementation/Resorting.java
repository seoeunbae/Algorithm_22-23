package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Resorting {

    static ArrayList<String> numbers = new ArrayList<>(List.of("0", "1", "2", "3", "4", "5", "6", "7" ,"8", "9"));
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split("");
        for(String each : s){
            if(numbers.contains(each)){
                count += Integer.parseInt(each);
            } else {
                sb.append(each);
            }
        }
        sb.append(count);

        System.out.println(sb.toString());
    }
}
