def solution(users, emoticons):
    answer_user = answer_price = 0
    for comb in yield_discount_rate_price_combination(emoticons, []):
        comb_user = comb_price = 0
        for criteria_rate , criteria_price in users:
            price = sum(map(lambda x: x[1], filter(lambda x: x[0] > criteria_rate, comb)))
            if price >= criteria_price:
                comb_user+=1
            else:
                comb_price+=price
        if comb_user > answer_user or (comb_user == answer_user and comb_price > answer_price):
            answer_user, answer_price = comb_user, comb_price

    return [answer_user, answer_price]

# (discount_rate , price)=> (할인율,판매액)
def yield_discount_rate_price_combination(emoticons, prefix):
    if not emoticons:
        yield prefix
        return
    for i in range (10 ,50 , 10):
        price = emoticons[0] * ( 1 - 0.01 * i)
        yield from yield_discount_rate_price_combination(emoticons[1:], prefix + [(i, price)])

