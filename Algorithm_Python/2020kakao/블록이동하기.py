def solution(board):
    ax = [0,1,0,-1]
    ay = [1,0,-1,0]
    좌표 = [(1,1), (1,2)]


    return 최단경로(좌표, ax, ay, board)


def 최단경로(좌표, ax, ay, board):
    list = []
    list.append([(1,1),(1,2)])
    count = 1
    while list is not None:
        poped = list.pop()
        left = poped[0] #(1,1)
        right = poped[1] #(1,2)
            # 1. 상하좌우 이동
        for i in range(0,4):
            leftx = left[0] + ax[i] #(1)
            lefty = left[1] + ay[i]
            rightx = right[0] + ax[i] #(1)
            righty = right[1] + ay[i]

            if leftx < 0 or leftx >= len(board) or lefty < 0 or lefty >= len(board) or rightx < 0 or rightx >= len(board) or righty < 0 or righty >= len(board):
                break # [(x,y), right]
            if board[leftx][lefty] == 1 or board[rightx][righty] == 1:
                break
            list.append([(leftx,lefty), (rightx,righty)])
            count+=1
       #2. 회전 이동 1. right 회전시키기
        if board[left[0]+1][left[1]] == 0 and board[left[0]+1][left[1]-1] == 0:
            list.append([(left[0]+1, left[1]), right])
    return count
list = []
list.append([(1,1),(1,2)])
def 최단경로_1( list, ax, ay, board, count):

    while list is not None:
        poped = list.pop()
        left = poped[0] #(1,1)
        right = poped[1] #(1,2)
        # 1. 상하좌우 이동
        for i in range(0,4):
            leftx = left[0] + ax[i] #(1)
            lefty = left[1] + ay[i]
            rightx = right[0] + ax[i] #(1)
            righty = right[1] + ay[i]

            if leftx < 0 or leftx >= len(board) or lefty < 0 or lefty >= len(board) or rightx < 0 or rightx >= len(board) or righty < 0 or righty >= len(board):
                break # [(x,y), right]
            if board[leftx][lefty] == 1 or board[rightx][righty] == 1:
                break
            list.append([(leftx,lefty), (rightx,righty)])
            count+=1
            최단경로_1(list, ax, ay ,board, count)
            count-=1
            list.pop()
        #2. 회전 이동 1. right 회전시키기
        if board[left[0]+1][left[1]] == 0 and board[left[0]+1][left[1]-1] == 0:
            list.append([(left[0]+1, left[1]), right])
            count+=1
            최단경로_1(list, ax, ay, board, count)
            list.pop()
            count-=1
    return count




def rotateleft(좌표)
    #좌표 = [(1,1),(1,2)](왼,오) -> [(1,1),(2,1)](위,아래)
    # 확블록 = (2,2)


def rotateright(좌표):
    #좌표 = [(1,1),(1,2)](왼,오) -> [(2,2),(1,2)](아래,위)
    #확인해야하는 블록= (2,1)