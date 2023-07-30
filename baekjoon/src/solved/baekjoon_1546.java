package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_1546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.valueOf(br.readLine());
        String[] numbers = br.readLine().split(" ");
        System.out.println(calculateAverage(changeScores(numbers)));
    }

    public static double[] changeScores(String[] numbers){
        double[] scores = Arrays.stream(numbers).mapToDouble(Double::parseDouble).toArray();
        double M = Arrays.stream(scores).max().getAsDouble();
        for( int i = 0 ; i < scores.length ; i++ ){
            scores[i] = (scores[i]/M) * 100;
        }
        return scores;
    }

    public static double calculateAverage(double[] scores){
        double sum = 0;
        for(double score : scores){
            sum += score;
        }
        return sum / scores.length;

    }
}