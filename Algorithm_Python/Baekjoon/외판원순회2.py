
from collections import deque

n = int(input())
board = []

for _ in range(n):
    board.append(list(map(lambda x: 1111111 if x == 0 else x, map(int, input().split()))))


answer = []


def dfs(x: int):
    visited = [0 for i in range(n)]
    dq = deque()
    dq.append(x)

    total_distance = 0
    while dq:
        pop = dq.pop()
        if visited[pop] == 1:
            continue
        visited[pop] = 1
        if sum(visited) == 4:
            total_distance = total_distance + board[pop][x]
            return total_distance

        min = 22222222
        for i in range(n):
            if visited[i] == 0 and board[pop][i] != 1111111:
                if min > board[pop][i] :
                    min = board[pop][i]
                    dq.append(i)
                    total_distance += min
    return total_distance

for zz in range(n):
    print(zz)
    answer.append(dfs(zz))

print(answer)
print(min(answer))

