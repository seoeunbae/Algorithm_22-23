package solved;

public class RemoveElement {
    public static void main(String[] args) {

    }

    public static int Func(int[] nums){
        if( nums.length == 0) return 0;
        int result = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] != nums[i-1]){
                nums[result] = nums[i];
                result++;
            }
        }
        return result;
    }
}
