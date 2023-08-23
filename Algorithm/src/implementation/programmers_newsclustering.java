package implementation;

import java.util.*;

public class programmers_newsclustering {

    static String[] split1;
    static String[] split2;
    static int[] array;

    public static void main(String[] args) {
        System.out.println(solution("AAbbaa_AAbb", "BBB"));
    }



    public static int solution(String str1, String str2) {
        //lower case change
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        //split
        split1 = new String[str1.length()-1];
        array = new int[str1.length()-1];
        split2 = new String[str2.length()-1];
        for(int i=0 ; i < str1.length()-1 ; i++){
            String temp = str1.substring(i,i+2);
            split1[i] = temp;
        }
        for(int i=0 ; i < str2.length()-1 ; i++){
            String temp = str2.substring(i,i+2);
            split2[i]=temp;
        }
        List<String> set1 = extractValidElements(str1);
        List<String> set2 = extractValidElements(str2);
        double u = 0;
        double n = 0;

        while (!set1.isEmpty()) {
            String target = set1.get(0);
            int targetSizeOfSet1 = 0;
            int targetSizeOfSet2 = 0;
            while (set1.contains(target)) {
                set1.remove(target);
                targetSizeOfSet1++;
            }
            while (set2.contains(target)) {
                set2.remove(target);
                targetSizeOfSet2++;
            }
            if (targetSizeOfSet2 > 0) {
                n += Math.min(targetSizeOfSet1, targetSizeOfSet2);
                u += Math.max(targetSizeOfSet1, targetSizeOfSet2);
            } else {
                u += targetSizeOfSet1;
            }
        }
        //자카드 유사도 체크 -> 교집합, 합집합 체크

        u += set2.size();
        double ja = (double) n / u;
        System.out.println((n/u)*65536 ) ;

        if(u == 0 ) {
            return (int) (ja = 1 * 65536);
        }
        ja = ((n/u) * 65536 );
        return (int) Math.floor(ja);
    }

    public static boolean match(String s){
        return s.matches("^[a-z]*$");
    }

    private static List<String> extractValidElements(String str) {
        List<String> set = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String temp = str.substring(i, i + 2);
            if (!((temp.charAt(0) >= 'A' && temp.charAt(0) <= 'Z')
                    || (temp.charAt(0) >= 'a' && temp.charAt(0) <= 'z'))) {
                continue;
            }
            if (!((temp.charAt(1) >= 'A' && temp.charAt(1) <= 'Z')
                    || (temp.charAt(1) >= 'a' && temp.charAt(1) <= 'z'))) {
                continue;
            }
            set.add(temp.toUpperCase());
        }
        return set;
    }


}
