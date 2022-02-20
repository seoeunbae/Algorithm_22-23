package unsolved.Medium;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s){
        int start = 0;
        String temp = "";
        String result = "";
        for (int i=0;i<s.length();i++){
            int index = temp.indexOf(s.charAt(i));
            System.out.println(i+" "+index);
            if(index != -1){ // temp안에 해당문자가 존재할때
                start = start + index + 1; //temp에 저장할 문자열의 시작점을
            }
            temp = s.substring(start,i+1);
            if(result.length()<temp.length()){
                result = temp;
            }

        }
        return result.length();
    }
}

//1. .substring()을 사용한다.
//2. 시간복잡도는 O(n)
//3. temp를 사용해서 n번 부분해를 계산해주고, 기존의 substring보다 길경우, 대체한다.

