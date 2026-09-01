public class Solution {
    public int MinMoves(string[] classroom, int energy) {
        int n = classroom.Length, m = classroom[0].Length;
        Queue<int[]> q = new Queue<int[]>();

        int lc = 0;
        int sx = 0, sy = 0;

        int[,] litterId = new int[n, m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                litterId[i, j] = -1;

                if (classroom[i][j] == 'L') {
                    litterId[i, j] = lc++;
                }
                else if (classroom[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }

        int allCollected = (1 << lc) - 1;

        int[,,] visited = new int[n, m, 1 << lc];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int mask = 0; mask < (1 << lc); mask++) {
                    visited[i, j, mask] = -1;
                }
            }
        }

        q.Enqueue(new int[] { sx, sy, energy, 0 });
        visited[sx, sy, 0] = energy;

        int moves = 0;

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        while (q.Count > 0) {
            int size = q.Count;

            while (size-- > 0) {
                int[] cur = q.Dequeue();

                int x = cur[0];
                int y = cur[1];
                int currEnergy = cur[2];
                int mask = cur[3];

                if (classroom[x][y] == 'L') {
                    mask |= 1 << litterId[x, y];
                }

                if (mask == allCollected) {
                    return moves;
                }

                if (classroom[x][y] == 'R') {
                    currEnergy = energy;
                }

                if (currEnergy == 0)
                    continue;

                int newEnergy = currEnergy - 1;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                        continue;

                    if (classroom[nx][ny] == 'X')
                        continue;

                    int newMask = mask;

                    if (classroom[nx][ny] == 'L') {
                        newMask |= 1 << litterId[nx, ny];
                    }

                    if (visited[nx, ny, newMask] >= newEnergy)
                        continue;

                    visited[nx, ny, newMask] = newEnergy;

                    q.Enqueue(new int[] {
                        nx, ny, newEnergy, newMask
                    });
                }
            }

            moves++;
        }

        return -1;
    }
}