package solved;

import javax.sound.midi.SysexMessage;
import java.util.Arrays;
import java.util.Scanner;

public class BeautifulMatrix {
    public static void main(String[] args) {
        Integer[][] mat =new Integer[5][5];
        Scanner scanner = new Scanner(System.in);

        for(int col=0;col<5;col++){
            for(int row=0;row<5;row++){
                mat[col][row] = scanner.nextInt();
                if(mat[col][row]==1){
                    System.out.println(Math.abs(2-col) + Math.abs(2-row));
                }
            }
        }

    }


}
