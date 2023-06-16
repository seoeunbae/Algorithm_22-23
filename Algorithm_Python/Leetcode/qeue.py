import collections
from collections import deque


def solution():
    print(5+":" + 5)
    queue = [3,3,3,3,3,3]
    result = [0 for i in range (3)]
    candidate= [1,2,3]
    global dict_q
    dict_q = collections.Counter(queue)
    print(dict_q)
    count_one = dict_q[1]
    count_two = dict_q[2]
    count_three = dict_q[3]
    most = dict_q.most_common()
    print(most)
    most_element = most[0][0]
    print(most_element)
    candidate.pop(candidate.index(most_element))
    loop = 0
    if dict_q[1] == dict_q[2] == dict_q[3]:
        return [0,0,0]
    if len(queue) == most[0][1]:
        result[most-1] = 0
        n = len(queue)/3
        for i in candidate:
            result[i-1] = n
    while dict_q[1] != dict_q[2] != dict_q[3]:
        loop+=1
        if loop >= 900000:
            return
        if dict_q[1] == dict_q[2] == dict_q[3]:
            return
        else:
            # for ord, cnt in dict_q:
            #     if ord is not order:
            #         count -= cnt

            dict_q[queue.pop()] -= 1
            for i in candidate:
                queue.append(i)
                result[i-1] += 1

            # dict_q = collections.Counter(queue)
        return result








solution()