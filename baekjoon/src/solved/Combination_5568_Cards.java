package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Combination_5568_Cards {
    static int N;
    static int K;
    static String[] cards;
    static boolean[] visited;
    static HashSet<String> selectedCase = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        cards = new String[N];

        for(int i=0 ; i < N ; i++){
            cards[i]= br.readLine();
        }
        visited = new boolean[N];
        selectCard( K, "");

        System.out.println(selectedCase.size());

    }

    public static void selectCard(int remain, String k){
        if(remain == 0){
            selectedCase.add(k);
            return;
        }

        for(int i = 0 ; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                selectCard(remain-1, k + cards[i]);
                visited[i] = false;
            }
        }
    }
}

//카드를 뽑았을 때 모든 경우의 수를 전부 계산한다.
//물론, 전부 계산하면 중복된 값이 발생하기 때문에 HashSet에다가 넣어주면 중복된 값은 입력되지 않는다!
//재귀함수를 이용하여, 아직 뽑지 않았으면(if(!visited[i])) 한 장을 뽑고,
// 그 다음 번호부터 하나씩 뽑는다. 전부 다 뽑았으면(remain == 0) HashSet에 넣고 함수를 종료한다. 그리고, 함수를 나오면서, 상위 함수로 돌아가서 뽑은 흔적을 지워준다. 그래야만 뒤에 진행되는 반복문에서 그 카드를 나중에 뽑을 수 있다.