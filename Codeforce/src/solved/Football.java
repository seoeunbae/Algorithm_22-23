package solved;

import java.util.Scanner;

public class Football {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(Func(s));
    }

    public static String Func(String s){
        String[] splits = s.split("");
        int count = 1;
        int pre = Integer.parseInt(splits[0]);
        for(int i=1;i<splits.length;i++){
            if( splits[i].equals("0") && pre==0){
                count++;
                pre = Integer.parseInt(splits[i]);
                if(count>6){
                    return "YES";
                }
            }else if(splits[i].equals("1") && pre == 1){
                count++;
                pre = Integer.parseInt(splits[i]);
                if( count > 6){
                    return "YES";
                }
            } else {
                pre = Integer.parseInt(splits[i]);
                count =1;
            }
        }
        return "NO";
    }
}
//시간복잡도:O(스트링개수 N)
//주제: 구현, 스트링