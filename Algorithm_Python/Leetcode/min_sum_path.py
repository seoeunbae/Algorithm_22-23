# leetcode 64

class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """

        m = len(grid)
        n = len(grid[0])

        sum_grid = [[0 for i in range(n)] for j in range(m)]

        sum_grid[0][0] = grid[0][0]

        if m == n == 1:
            return sum_grid[0][0]

        for i in range (n):
            for j in range (m):
                if i == 0 and j > 0:
                    sum_grid[j][i] = grid[j][i] + sum_grid[j-1][i]
                elif j == 0 and i > 0:
                    sum_grid[j][i] = grid[j][i] + sum_grid[j][i-1]
                else:
                    sum_grid[j][i] = min(grid[j][i] + sum_grid[j-1][i], grid[j][i] + sum_grid[j][i-1])

        return sum_grid[m-1][n-1]