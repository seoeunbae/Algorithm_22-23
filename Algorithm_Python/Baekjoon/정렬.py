def 정렬():
    n = input()
    array = n.split()
    array.sort()

#---------------------------------------#

def 버블정렬():
    n = input()
    array = list(map(int,n.split()))

    for i in range(len(array)-1, -1, -1):
        for j in range(i):
            if array[j] > array[j+1]:
                temp = array[j+1]
                array[j+1] = array[j]
                array[j] = temp
    print(array)


def 삽입정렬():
    n = input()
    array = list(map(int,n.split()))

    for i in range(1, len(array)):
        for j in range(i, 0, -1):
            if array[j-1] > array[j]:
                temp = array[j-1]
                array[j-1] = array[j]
                array[j] = temp

    print(array)


def 선택정렬():
    n = input()
    array = list(map(int,n.split()))

    for i in range(len(array)):
        idx = array.index(min(array[i:]))
        temp = array[i]
        array[i] = array[idx]
        array[idx] = temp
    print(array)


# ----------N^2--------------------#

def 퀵정렬():
    n = input()
    array = list(map(int,n.split()))
    front = []
    rear = []

    pivot = array[0]
    for i in range(1, len(array)):
        if array[i] < array[0]:
            front.append(array[i])
        else:
            rear.append(array[i])

