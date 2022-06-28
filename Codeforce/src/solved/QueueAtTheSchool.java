package solved;

import java.util.Scanner;

public class QueueAtTheSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer N = scanner.nextInt();
        Integer second = scanner.nextInt();
        scanner.nextLine();
        String string = scanner.nextLine();
        String[] func = Func(string, second);
        for(String result: func){
            System.out.print(result);
        }
    }

    public static String[] Func(String string, Integer second){
        String[] splits = string.split("");
        for(int j=0;j<second;j++){
            for(int i=0;i< splits.length;i++){
                if(i== splits.length-1 && splits[i].equals("B") ){
                    continue;
                }
                else if(splits[i].equals("B") && splits[i+1].equals("G")){
                    splits[i]="G";
                    splits[i+1]="B";
                    i++;
                } else continue;
            }
        }
        return splits;
    }
}
//시간복잡도: O(N*t)
//주제: 최단거리, 그래프, 구현