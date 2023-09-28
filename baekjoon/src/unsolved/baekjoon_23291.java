//package unsolved;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class baekjoon_23291 {
//    static BufferedReader in;
//    static StringTokenizer st;
//    static int n;
//    static int k;
//    static int[][] fishes;
//
//    public static void main(String[] args) throws IOException {
//        in = new BufferedReader(new InputStreamReader(System.in));
//        String[] s = in.readLine().split(" ");
//        n = Integer.parseInt(s[0]);
//        k = Integer.parseInt(s[1]); // 차이
//
//        fishes = new int[n][n];
//        st = new StringTokenizer(in.readLine());
//        int min = 10001;
//        //초기화
//        for(int i=0 ; i < n ; i++){
//            fishes[n-1][i] = Integer.parseInt(st.nextToken());
//        }
//
//        int diff = 0;
//        int time = 0;
//        while(diff > k){
//            for(int i=0 ; i < n ; i++){
//                for(int j=0 ; j < n ; j++){
//                    if(min > fishes[i][j]){
//                        min = fishes[i][j];
//                    }
//                }
//            }
//            //최소 물고기에 +1 하기
//            for(int i=0 ; i < n ; i++){
//                for(int j=0 ; j < n ; j++){
//                   if( min == fishes[i][j]){
//                       fishes[i][j]++;
//                   }
//                }
//            }
//            //TODO : 1번째 정리 + 왼쪽 어항 -> 어차피 재나열하기때문에 수정필요!
//            int first = 0;
//            int last = 0;
////            for(int i=0 ; i < n ; i++){
//                for(int j=0 ; j < n ; j++) {
//                    if(fishes[n-1][j]!=0){ //x
//                        first = j; //첫번째 안 빈 인덱스
//                        break;
//                    }
//
//                }
////            }
//
//
//            for(int j=first ; j < n ; j++){ //x j=0 (n-1,0)->(n-2,0) / (n-2,0) -> (n-2,1)
//                //1. 가장 왼쪽에 존재하는 비지않은 배열 이거나
//                //2. 사이즈가 2보다 큰경우
//                //--------
//                //3. 리스트의 사이즈+i인덱스 가 n이하인 경우
//                for(int i=n-1 ; i >= 0 ;i++){ //y
//                    if(fishes[i][j]!=0){ //
//                        fishes[][] = fishes[i][j];
//                    }
//                }
//                ArrayList<Integer> array = fishes2[i];//(0->3)
//                if(array.size() + i >= n) continue;
//                for(int j=0 ; j < array.size() ; j++){
//                    fishes2[i+j+1].add(array.get(j));
//                }
//            }
//            moveFish();
//            int[] rearrange = rearrange();
//            //2번째 정리
//            time++;
//        }
//    }
//    public static void moveFish(){
//
//    }
//
//    public static int[] rearrange(){
//        int first = 0;
//        for(int i=0 ; i < n ; i++){
//            if(!fishes2[i].isEmpty()){
//                first = i;
//                break;
//            }
//        }
//        for(int f=0 ; f < n ; ) {
//            for (int i = first; i < n; i++) {
//                ArrayList<Integer> array = fishes2[i];
//                //(0->3)
//                int size = array.size();
//                for (int s = 0; s < size; s++) {
//                    fishes[f++] = array.get(s);
//                }
//            }
//        }
//        return fishes;
//    }
//
//}
