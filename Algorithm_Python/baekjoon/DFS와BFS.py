from collections import deque

def dfs(s: int, n: int, board, visit):
    print(s, end= " ")
    visit[s] = 1

    for i in range(1, n+1):
        if visit[i] == 1 or board[s][i] == 0:
            continue


        return dfs(i, n, board, visit)


def bfs(s: int, board, n: int, visit):

    dq = deque() #큐
    dq.append(s)

    while dq:
        x = dq.popleft()

        if visit[x] == 1:
            continue
        print(x, end= " ")
        visit[x] = 1
        for i in range(1,n+1):
            if board[s][i] == 0 or visit[i] == 1:
                continue
            dq.append(i)
    return

def solution():

    n, m, s = map(int, input().split())
    global board
    board = [[0 for i in range(n+1)] for j in range(n+1)]

    global visit
    visit = [0 for _ in range(n + 1)]

    for i in range(m):
        source, desti = map(int, input().split())
        board[source][desti] = 1
        board[desti][source] = 1



    dfs(s, n,board, visit)
    print()
    visit = [0 for _ in range (n+1)]
    bfs(s, board, n, visit)


solution()