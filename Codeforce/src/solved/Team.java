package solved;

import java.util.Scanner;

public class Team {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer problemCount = Integer.parseInt(scanner.nextLine());
        int solved = 0;
        for(int i=0;i<problemCount;i++){
            Boolean bool = Func(scanner.nextLine());
            System.out.println("bool: "+bool);
            if(bool) solved++;
            else continue;
        }
        System.out.println("solved: "+solved);
    }

    public static Boolean Func(String nextLine){
        String[] splits = nextLine.split(" ");
        int ok =0;
        for(int i=0 ; i < splits.length ; i++) {
            System.out.println("splits[i] "+splits[i]);
            if (splits[i].equals("1")) ok++;
            else ok--;
        }
        System.out.println("ok: "+ok);
        if(ok>=1) return true;
        else return false;
    }
}
