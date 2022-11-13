package solved;

public class kabank22 {
    static int[][] map;

    public static void main(int[] rooms) {
        int count = rooms.length;
        map = new int[rooms.length+1][rooms.length+1];

        for(int i=0 ; i < count ; i++){
            map[i+1][rooms[i]] = 1;
        }
    }
}
