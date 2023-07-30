class Solution(object):
    def func(self,idx, s_idx,s, bool, limit):
        # print("start ",s_idx)
        # print("end" , idx)
        if limit == idx:
            return bool

        if s[s_idx:idx+1] in wordSet:
            bool = True
            return self.func(idx+1, idx+1, s, bool, limit) or self.func(idx+1, s_idx ,s , bool , limit)
            s
        else:
            idx += 1
            bool = False
            return self.func(idx,s_idx, s, bool, limit)

    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        global wordSet
        wordSet = set()
        for i in wordDict:
            wordSet.add(i)
        bool = False
        return self.func(0,0, s, bool, len(s))
    # Time limit Exceeded
