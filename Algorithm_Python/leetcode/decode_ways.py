class Solution(object):
    def check_valid(self,s, st, en):
        return 0 < int(str(s[st:en+1])) < 27

    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        if s[0] == "0":
            return 0
        ans = [[0 for x in range(n)] for y in range (2)]
        print(ans)
        ans[0][0] = 1
        ans[1][0] = 0

        for i in range(1, n, 1):
            # 0인 경우 = 이전과 독립적으로 세는 경우
            if s[i] != "0":
                ans[0][i] = ans[0][i-1] + ans[1][i-1]

            # 1인 경우 = 이전과 붙여서 세는 경우
            if self.check_valid(s,i-1, i):
                ans[1][i] = ans[0][i-1]
            else:
                ans[1][i] = 0
        result = ans[0][n-1]+ ans[1][n-1]
        return result