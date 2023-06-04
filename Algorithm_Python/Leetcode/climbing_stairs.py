def climbStairs(self, n: int) -> int:
    climb = int[n+1][2]
    climb[0][0] = climb[0][1] = climb[1][1] = 0
    climb[1][0] = 1

    for i in range(1, n):
        climb[i][0] = climb[i-1][0] + climb[i-1][1]
        climb[i][1] = climb[i-2][0] + climb[i-1][1]

    return climb[n][0] + climb[n][1]
        