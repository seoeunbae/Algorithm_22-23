package solved;

public class prog_92344 {
    public static void main(String[] args) {
        int[][] str1= {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] str2 ={{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};
        System.out.println(solution(str1, str2));
    }
        static int[][] calcul;
        static int n;
        static int m;
        public static int solution(int[][] board, int[][] skill) {
//1 : 공격 , 2 : 회복

            int answer=0;
            n = board.length;//y
            m = board[0].length;//x
            calcul = new int[n][m];
            for(int i=0; i < skill.length; i++){
                int type = skill[i][0];
                int r1 = skill[i][1]; //시작
                int c1 = skill[i][2];
                int r2 = skill[i][3]; //끝
                int c2 = skill[i][4];
                int degree = skill[i][5];

                if (type == 1){
                    //1. 첫번째 행을 계산
                    calcul[r1][c1] -= degree;

                    for(int x = c1+1 ; x <= c2 ; x++){
                        calcul[r1][x] += calcul[r1][x-1];
                    }

                    //2. 아래 열들을 계산
                    for(int y = r1+1 ; y <= r2 ; y++){
                        for(int x = c1 ; x <= c2 ; x++){
                            calcul[y][x] += calcul[y-1][x];
                        }
                    }
                }else {
                    //1. 첫번째 행을 계산
                    calcul[r1][c1] += degree;

                    for(int x = c1+1 ; x <= c2 ; x++){
                        calcul[r1][x] += calcul[r1][x-1];
                    }

                    //2. 아래 열들을 계산
                    for(int y = r1+1 ; y <= r2 ; y++){
                        for(int x = c1 ; x <= c2 ; x++){
                            calcul[y][x] += calcul[y-1][x];
                        }
                    }
                }

                for(int y=0 ; y < n ; y++){
                    for(int x =0; x < m ; x++){
                        System.out.print(calcul[y][x]+ " ");
                    }
                    System.out.println();
                }
            }

            for(int y=0 ; y < n ; y++){
                for(int x =0; x < m ; x++){
                    board[y][x]+=calcul[y][x];
                    System.out.print(board[y][x]+ " ");
                }
                System.out.println();
            }


            for(int y=0 ; y < n ; y++){
                for(int x =0; x < m ; x++){
                    if(board[y][x] > 0) answer++;
                }
            }
            return answer;
        }


}

