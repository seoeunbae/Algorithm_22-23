package implementation;

public class programmers_17676 {
	static int start = 0;
	static int end = 0;
	
	public static void main(String[] args) {
		String[] lines = {"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"};
		solution(lines);
	}
	
	public static int solution(String[] lines) {
		for(int i=0 ; i < lines.length ; i++) {
			String str = lines[i];
			String[] s = str.split(" "); //s[0] == year
 			String time = s[1];
 			String[] hms = time.split(":");
 			int hour = Integer.parseInt(hms[0]) * 60 * 60;
 			int minute = Integer.parseInt(hms[1]) * 60;
 			if ( i==0 ) {
 				start = hour + minute;
 			}
 			if (i== lines.length-1) {
 				end = hour + minute + 60;
 			}
 			double second = Double.parseDouble(hms[2]);
			String[] durings = s[2].split("[a-z]+");
//			System.out.println(durings[0]);
			double during = Double.parseDouble(durings[0]);
			System.out.println(second + " " + during);
			
			
		}
		
		
        return 1;
    }
}
