package solved;

public class TwoSum {

    public static void main(String[] args) {

    }
    static int[] result;
    public int[] twoSum(int[] nums, int target){
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i==j) continue;
                if(nums[i]+nums[j]==target){
                    result= new int[]{i,j};
                    return result;
                }
            }
        }
        return result;
    }
}
//numsp[]를 두번 순회하면서 합이 target인 경우 리턴을 한다.
