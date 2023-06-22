import sys

def check(temp_ACGT, ACGT):
    return temp_ACGT["A"] >= int(ACGT[0]) and temp_ACGT["C"] >= int(ACGT[1]) and temp_ACGT["G"] >= int(ACGT[2]) and temp_ACGT["T"] >= int(ACGT[3])


def DNA():
    S, P = input().split()
    P = int(P)
    str = input()
    n = len(str)
    ACGT = list(map(int,input().split()))
    temp_ACGT = { "A" : 0, "C" : 0, "G" : 0, "T" : 0}
    answer = 0

    s = str[:P]
    for i in s:
        temp_ACGT[i] += 1
    if check(temp_ACGT, ACGT):
        answer += 1

    j = 0

    while True:
        if P+j >= n:
            break
        temp_ACGT[str[j]] -= 1
        temp_ACGT[str[P+j]] += 1
        # print(temp_ACGT)
        j += 1
        if check(temp_ACGT, ACGT):
            answer += 1

    print(answer)
    return answer

DNA()