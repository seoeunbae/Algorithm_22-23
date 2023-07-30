from collections import deque
import sys

while True:
    str = input()
    stack = deque()
    if str == ".":
        break
    for i in str:
        if i == "(" or i == "[":
            stack.appendleft(i)

        elif i == ")":
            if len(stack) != 0 and "(" == stack[0]:
                stack.popleft()
            else :
                stack.appendleft(")")
                break
        elif i == "]":
            if len(stack) != 0 and "[" == stack[0]:
                stack.popleft()
            else:
                stack.appendleft("]")
                break

    if len(stack) == 0:
        print("yes")
    else:
        print("no")

