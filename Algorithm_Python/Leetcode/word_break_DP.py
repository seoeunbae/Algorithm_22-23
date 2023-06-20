class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [True] + [False] * len(s)
        for i in range(1, len(s)+1):
            for word in wordDict:
                if s[i-len(word):i] == word:
                    dp[i] = dp[i-len(word)]
                if dp[i]:
                    break
        return dp[-1]

    # unsolved - 다시도전하기