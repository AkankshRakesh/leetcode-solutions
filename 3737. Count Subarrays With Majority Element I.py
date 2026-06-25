class Solution:
    def countMajoritySubarrays(self, a: List[int], u: int) -> int:
        return sum(2*q>l for i in range(len(a)) 
            for l,q in enumerate(accumulate(map(lambda v:v==u,islice(a,i,None))),1))