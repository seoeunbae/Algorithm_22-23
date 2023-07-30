class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        n = len(prices)

        min_price = prices[0]
        max_profit = 0
        for i in range(n):
            cur_profit = prices[i] - min_price
            min_price = min(prices[i], min_price)
            max_profit = max(cur_profit, max_profit)

        return max_profit