package solved;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Baekjoon_10825 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Scores> student = new ArrayList<>();


        for(int i=0 ;i<n ;i++){
            String[] splits = scanner.nextLine().split(" ");
            student.add(new Scores(splits[0], Integer.parseInt(splits[1]), Integer.parseInt(splits[2]), Integer.parseInt(splits[3])));
        }
        Func(student);
    }

    public static class Scores{
        public String name;
        public Integer korean;
        public Integer english;
        public Integer math;
        public Scores(String name, Integer korean, Integer english, Integer math){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

    }
    public static void Func(List<Scores> students){
        Collections.sort(students, new Comparator<Scores>() {
            @Override
            public int compare(Scores o1, Scores o2) {
                int firstName = 0;
                int secondName = 0;
                if(o1.korean == o2.korean) {
                    if(o1.english == o2.english) {
                        if (o1.math == o2.math) {
                            return o1.name.compareTo(o2.name);
                        } else {
                            return o2.math - o1.math;
                        }
                    } else {
                         return o1.english - o2.english; // 증가(오름차순)
                    }
                } else {
                    return o2.korean - o1.korean; // 감소(내림차순)
                }
            }
        });

        for(int i=0;i<students.size();i++){
            System.out.println(students.get(i).name);
        }
    }
}
