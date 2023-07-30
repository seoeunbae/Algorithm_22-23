package bruteforce;

public class DigitTest1 {
    static int[][] board;

    public static void main(String[] args) {
        int N = 5;
        board = new int[N][N];
        int num = 1;
//        for(int i= 0 ; i < N ; i++){
//            for(int j = i ; j < N ; j++){
//                board[i][j] = num;
//                num++;
//            }
//        }

//        for(int i= 0 ; i < N ; i++){
//            for(int j = 0 ; j < N ; j++){
//                if (board[i][j]==0) System.out.print("  ");
//                else System.out.print(board[i][j]+ " ");
//            }
//            System.out.println();
//        }

        for(int i=0 ; i< N ; i++){
            for(int j = 0 ; j < i ; j++){
                System.out.print(" ");
            }
            for(int j=i; j< N;j++){
                System.out.print(num++);
            }
            System.out.println();
        }
    }
}
