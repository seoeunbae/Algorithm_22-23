import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
public class Musicc {
	public static void main(String[] args) {
		String[] strings = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		System.out.println(solution("CC#BCC#BCC#BCC#B", strings ));
	}
	
	 public static class Music implements Comparable<Music>{
	        public String name;
	        int diff;
	        int id;
	        int length;
	        
	        Music(int id , String name, int diff, int length){
	            this.id = id;
	            this.name = name;
	            this.diff= diff;
	            this.length = length;
	        }
	        
	        @Override
			public int compareTo(Music o) {
	            if(this.length==o.length) {
	                if(o.diff==this.diff) return this.id - o.id; 
				    else return o.diff-this.diff;    
	            }else{
	                return o.length-this.length;
	            }
	            
			}
	    }    	
	    
	    static PriorityQueue<Music> pq ;
	    
	    public static String solution(String m, String[] musicinfos) {
	        String ans = "";
	        int max = 0; // 가장 긴 
	        int maxD = 0; // 가장 긴 음악시간
	        int idx = 0;
	        boolean flag = false;
	        String[] ms = splitNote(m);
	        pq  = new PriorityQueue<>();
	        for(int z=0; z < musicinfos.length ; z++){
	            String[] infos = musicinfos[z].split(",");
	            String start = infos[0];
	            String[] starts = start.split(":");
	            int startT = Integer.parseInt(starts[0])*60 + Integer.parseInt(starts[1]);
	            // System.out.println(startT);

	            //12*60+0;
	            String end = infos[1];
	            String[] ends = end.split(":");
	            int endT = Integer.parseInt(ends[0])*60 + Integer.parseInt(ends[1]);
	            // System.out.println(endT);

	            //12*60+14;
	            String name = infos[2];
	            // System.out.println(name);
	            String note = infos[3];
	            String[] notes = splitNote(note);
	            int len = notes.length;//3
	            int diff = endT-startT;
	            // Music  music = new Music(name, diff);
	            // pq.add(music);
	            // if(maxD < diff){ 
	            //     maxD = diff;
	            //     flag = true;
	            //     idx = z;
	            // }
	            String[] compare = new String[diff];
	            for(int i=0 ; i < diff ; i++){            
	                compare[i] = notes[i%len];
	            }
	             System.out.println(Arrays.toString(notes));
	            int prevIdx = 0;
	            int msIdx = 0;
	            int length = 0;
	            for(int i=0 ; i < diff ; i++){
	                if(compare[i].equals(ms[msIdx % ms.length])){
	                    prevIdx = i; 
	                    msIdx++; 
	                    length++;
	                } else {  
                        if(msIdx == ms.length-1){
                            Music music =new Music(z,name, diff,length);
                            pq.offer(music); 	                	                    
                            continue;
                        }
	                }
	            }
	            
	            if(length != 0 ) {
                    Music music = new Music(z,name, diff,length);
	                pq.offer(music);  	             	                 
	            } 	         	  
	        }
            Music mus =pq.poll();
	        ans = mus.name;
        System.out.println(mus.length);
            if(ans.equals("") || mus.length < ms.length) ans ="(None)";
	        return ans;
	        
	    }
    
    public static String[] splitNote(String note){
        if(note.contains("#")){
            note=note.replaceAll("C#","c");
            note=note.replaceAll("D#","d");
            note=note.replaceAll("F#","f");
            note=note.replaceAll("G#","g");
            note=note.replaceAll("A#","a");
            return note.split("");
        }else{
            return note.split("");
        }
    }
}




    
    
