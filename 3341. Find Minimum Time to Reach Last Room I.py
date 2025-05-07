class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        n = len(moveTime)
        m = len(moveTime[0])

        pq = [(0,0,0)]
        heapify(pq)

        visited = set()

        while pq:
            cur = heappop(pq)
            if cur[1]==n-1 and cur[2]==m-1: # check if we are at destination and return immediately
                return cur[0]

            for adj in [
                (cur[1]-1, cur[2]),
                (cur[1]+1, cur[2]),
                (cur[1], cur[2]+1),
                (cur[1], cur[2]-1)
            ]:
                if not (0<=adj[0]<n and 0<=adj[1]<m):
                    continue
                if adj in visited:
                    continue
                visited.add(adj)
                adjMoveTime = max(cur[0], moveTime[adj[0]][adj[1]])
                adjMoveTime+=1
                heappush(pq, (adjMoveTime, adj[0], adj[1]))