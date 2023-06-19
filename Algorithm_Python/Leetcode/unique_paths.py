class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        global map
        map = [[0 for i in range (n)] for j in range (m)]

        for i in range (m):
            map[i][0] = 1
        for i in range (n):
            map[0][i] = 1

        for i in range (1, n):
            for j in range (1, m):
                map[j][i] = map[j-1][i] + map[j][i-1]

        return map[m-1][n-1]


