class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n == 1:
            return nums[0]

        sum_array = [0 for i in range(n)]
        sum_array[0] = nums[0]

        for i in range(1, n):
            sum = sum_array[i-1]
            # if sum + nums[i] < nums[i]:
            #     sum_array[i] = nums[i]
            # elif sum + nums[i] >= nums[i]:
            #     sum_array[i] = sum + nums[i]
            sum_array[i] = max(sum+nums[i], nums[i])
        return max(sum_array)