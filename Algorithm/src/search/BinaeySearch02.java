package search;

public class BinaeySearch02 {
    static int[] array;
    static int target;
    static int start;
    static int end;

    public static Integer binarySearch(int[] array, int target, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start+end) / 2;

        if ( array[mid] == target){
            return mid;
        }
        else if( array[mid] > target){
            return binarySearch(array, target, start, mid-1);
        }
        else return binarySearch(array, target, mid + 1, end);
    }

    public static void main(String[] args) {
        Integer result = binarySearch(array, target, start, end);
        if(result == null){
            System.out.println("원소가 존재하지 않습니다.");
        }
        else System.out.println(result + 1);
    }
}
