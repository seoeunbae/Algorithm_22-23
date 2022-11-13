package solved;


public class kabank01 {
    static int KST = 9;
    static int HOUR_INDEX = 0;
    static int[] answer;

    public static void main(String args) {
        answer = new int[24];

        String[] logs = args.split("\\n |  ");

        for(int i=0 ; i< logs.length ; i++){
            String[] logss = logs[i].split(" ");
            //년 시간

                String[] hourDetail = logss[1].split(":");
                int hour = Integer.parseInt(hourDetail[HOUR_INDEX]) + KST;
                hour = hour > 23 ? hour - 23 : hour;
                answer[hour]++;
        }

    }

    public static void Func(){

    }
}
