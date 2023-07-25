import sys
n, m = map(int,input().split())
temp_list = []
total_list = []
used = set()
def permutation(level :int, temp_list:[]):
    if level == m:
        total_list.append(temp_list)
        print(" ".join(map(str,temp_list)))
        return

    for i in range(1,n+1):
        if i not in used:
            used.add(i)
            temp_list.append(i)
            permutation(level+1, temp_list)
            temp_list.remove(i)
            used.remove(i)

permutation(0, temp_list)
print(total_list)