package problem_solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Sort_Baekjoon_10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0 ; i < N ; i ++){
            String[] split = br.readLine().split(" ");

            String name = split[0];
            int korean = Integer.parseInt(split[1]);
            int english = Integer.parseInt(split[2]);
            int math = Integer.parseInt(split[3]);

            Student student = new Student();
            student.name = name;
            student.korean = korean;
            student.english = english;
            student.math = math;

            students.add(student);
        }

        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.korean == o2.korean) {
                    if (o1.english == o2.english) {
                        if(o1.math == o2.math){
                            return o1.name.compareTo(o2.name);
                        }
                        return o2.math - o1.math; //desc
                    }
                    return o1.english- o2.english; //asc
                }
                return o2.korean - o1.korean; //desc
            }
        });

        for(int i=0 ; i< students.size() ; i++){
            System.out.println(students.get(i).name);
        }



    }




    public static class Student{
        String name;
        int korean;
        int english;
        int math;
    }
}
