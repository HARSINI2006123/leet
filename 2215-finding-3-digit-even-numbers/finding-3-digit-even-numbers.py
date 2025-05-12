class Solution(object):
    def findEvenNumbers(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        from itertools import permutations

class Solution:
    def findEvenNumbers(self, digits):
        res = set()
        
        for perm in permutations(digits, 3):
            if perm[0] == 0:
                continue  # Skip leading zero
            num = perm[0]*100 + perm[1]*10 + perm[2]
            if num % 2 == 0:
                res.add(num)
        
        return sorted(res)
