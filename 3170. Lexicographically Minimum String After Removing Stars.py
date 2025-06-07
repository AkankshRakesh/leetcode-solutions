class Solution:
    def clearStars(self, s: str) -> str:
        
        ans = list(s)
        heap = []
        

        for i, char in enumerate(s):
            if char == '*' and heap:
                del_char, j = heapq.heappop(heap)
                ans[-j] = ''
                ans[i] = ''
            else:
                heapq.heappush(heap, (char, -i))

        return ''.join(ans)