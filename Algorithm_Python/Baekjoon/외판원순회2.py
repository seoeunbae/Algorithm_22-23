
from collections import deque

n = int(input())
board = []

for _ in range(n):
    board.append(list(map(lambda x: 1111111 if x == 0 else x, map(int, input().split()))))


answer = []

visit = [0 for i in range(n)]
global total_distance
total_distance = 0

global cost
cost = 0

global first
first = 0

def dfs(x: int, val: int, depth = 1):



    global cost
    if depth == n:
        for _cost in board[x]:
            if board[x].index(_cost) == first:
                cost = min(cost, val+_cost)
        return

    if visit[x]==1:
        return
    visit[x] = 1

    for _cost in board[x]:
        nx = board[x].index(_cost)
        if not visit[nx]:
            dfs(nx, val+_cost, depth+1)
            visit[nx] = 0


for i in range(n):
    visit = [False] * n
    first = i
    cost = 0
    dfs(i, 0)
print(cost)

