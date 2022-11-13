package solved;

import com.sun.source.util.TaskListener;

import java.util.*;

public class kabank04 {
    static int count;
    static int[] answer;
    static Queue<Integer> answerQueue = new LinkedList<>();
    static Queue<Integer> waiting = new LinkedList<>();
    static final int MAX_EXEC_TIME = 10000;
    static final int IMPORTANCE_INDEX = 3;
    static final int SECTION_INDEX = 2;
    static boolean[] isEnd ;

    static final int EXEC_INDEX = 1;

    public static void main(int[][] jobs) {

        count = jobs.length;
        answer = new int[count];
        isEnd = new boolean[count+1];
        for(int i=0 ; i < count ; i ++){
            if(i==0) waiting.add(i+1);
        }
        List<Task> temp = new ArrayList<>();
        int time = 0;
        while(!waiting.isEmpty()){
            Integer currentTaskId = waiting.poll();
            answerQueue.add(jobs[currentTaskId-1][SECTION_INDEX]);
            isEnd[currentTaskId] = true;
            time += jobs[currentTaskId-1][EXEC_INDEX];

            for(int i = 0 ; i < count ; i++){
                if(jobs[i][EXEC_INDEX] < time){
                    temp.add(new Task(i, jobs[i][SECTION_INDEX],jobs[i][IMPORTANCE_INDEX]));
                    waiting.add(i+1);
                }
            }

            temp.sort(new Comparator<Task>() {
                @Override
                public int compare(Task o1, Task o2) {
                    return o2.importance-o1.importance;
                }
            });

            for(Task task : temp){
                waiting.add(task.id);
                answerQueue.peek().equals()
            }
            temp.size()



        }

        for(int i=0 ; i< answerQueue.size(); i++){
            answer[i] = answerQueue.poll();
        }

        return answer;
    }

    public static void Func(){

    }

    public static class Task{
        public int id;
        public int sectionId;
        public int importance;

        Task(int id, int sectionId, int importance){
            this.id = id;
//            this.reqTime = reqTime;
//            this.execTime = execTime;
            this.sectionId = sectionId;
            this.importance = importance;
        }
    }
}
