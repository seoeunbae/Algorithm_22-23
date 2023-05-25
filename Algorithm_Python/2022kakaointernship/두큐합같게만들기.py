from collections import deque
def solution(queue1, queue2):
    answer = -2
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    queue1_sum = sum(queue1)
    queue2_sum = sum(queue2)
    n = len(queue1)
    total = queue1_sum + queue2_sum

    if total % 2 == 1:
        return -1
    else:
        total /= 2

    count = 0
    whileCnt = 0;
    while queue1_sum != queue2_sum:
        whileCnt+=1
        if count > 2*n+1:
            return -1
        if whileCnt >= 599999:
            return -1

        if queue2_sum == total or queue1_sum == total:
            return count

        if queue2 and queue2_sum > queue1_sum:
            poped = queue2.popleft()
            queue1.append(poped)
            count+=1
            queue2_sum -= poped
            queue1_sum += poped

        elif queue1 and queue1_sum > queue2_sum :
            poped = queue1.popleft()
            count+=1
            queue1_sum -= poped
            queue2_sum += poped

    return count