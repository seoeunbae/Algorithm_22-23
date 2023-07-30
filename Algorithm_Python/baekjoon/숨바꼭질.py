from collections import deque

def solution():
    n, k = map(int, input().split())
    visited = [-1 for i in range(100001)]
    bfs(k, n, visited)
    return


def bfs(k: int, x : int, visited):
    dq = deque()
    dq.append(x)

    while dq:
        node = dq.popleft()
        print(node)
        if node == k:
            print(visited[node]+1)
            break
        for i in (node - 1, node + 1, 2 * node):
            if 0 <= i <= 100000 and visited[i] == -1:
                visited[i] = visited[node] + 1
                dq.append(i)


solution()