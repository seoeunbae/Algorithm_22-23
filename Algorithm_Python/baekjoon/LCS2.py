import sys
input = sys.stdin.readline


def solution():
    first = list(input())
    first.pop()
    second = list(input())
    second.pop()

    f_n = len(first)
    s_n = len(second)

    board = [[0 for i in range(s_n)] for j in range(f_n)]

    for i in range(1, f_n):
        for j in range(i, s_n):
            if first[i-1] == second[j-1]:
                board[i][j] = board[i-1][j-1] + 1
            else:
                board[i][j] = max(board[i-1][j], board[i][j-1])



    Path=[]

