package solved;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(Func(string));
    }

    public static Long Func(String string){
        String[] splits = string.split(" ");
        Long n = Long.valueOf(splits[0]);
        Long k = Long.valueOf(splits[1]);
        List<Long> arrayList= new ArrayList<>();
        for(Long i=1L;i<=n;i+=2){
            arrayList.add(i);
        }
        for(Long i=2L;i<=n;i+=2){
            arrayList.add(i);
        }
        return arrayList.get((int) (k-1));
    }
}
