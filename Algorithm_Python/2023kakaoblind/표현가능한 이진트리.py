def solution(numbers):
    return [int(expressible(number)) for number in numbers]

def expressible(number) -> bool:
    binary = convert_to_full_binary(number)
    return check(binary,binary[len(binary)//2])

# H : 0 , N : 1
# H : 1 , N : 1 + 2
# H : 2 , N : 1 + 2 + 4

def convert_to_full_binary(number) -> str:
    binary = bin(number)[2:]

    n, node = 0, 1
    while len(binary) > node:
        n += 1
        node += 2**n
    return "0"*(node-len(binary)) + binary



def check(binary, parent) -> bool:
    if len(binary) == 1:
        return True

    root_idx = len(binary) // 2
    root = binary[root_idx]
    if root == "0" and not all(child == "0" for child in binary):
        return False
    return check(binary[:root_idx], root) and check(binary[root_idx+1:], root)


solution([7,42,5])