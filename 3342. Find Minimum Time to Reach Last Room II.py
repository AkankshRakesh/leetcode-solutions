class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        rows, cols = len(moveTime), len(moveTime[0])
        pq = [(0, 0, 0, 0)]  # time, r, c, last
        distance = {(0, 0, 0): 0}
        while pq:
            t, r, c, l = heappop(pq)
            if (r, c) == (rows-1, cols-1):
                return t
            # this line is needed whenever we need to clear dupes in Dijkstra. It's not needed in classic Dijkstra but many problems need it so it's good to learn. in this problem we don't need it for accuracy but it helps a lot with time used
            if (r, c, l) in distance and t > distance[(r, c, l)]:
                continue
            for nr, nc in [(r+1, c), (r-1, c), (r, c+1), (r, c-1)]:
                if nr in range(rows) and nc in range(cols):
                    nt = max(t, moveTime[nr][nc]) + 1 + l
                    nl = 1 - l
                    if (nr, nc, nl) not in distance or nt < distance[(nr, nc, nl)]:
                        distance[(nr, nc, nl)] = nt
                        heappush(pq, (nt, nr, nc, nl))