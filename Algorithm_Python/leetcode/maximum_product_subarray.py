class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        min_array = [0 for i in range(n)]
        max_array = [0 for j in range(n)]
        min_array[0] = nums[0]
        max_array[0] = nums[0]
        for x in range (1, n):
            max_array[x] = max(max_array[x-1] * nums[x], nums[x], min_array[x-1] * nums[x])
            min_array[x] = min(min_array[x-1] * nums[x], nums[x], max_array[x-1] * nums[x])

        return max(max_array)
