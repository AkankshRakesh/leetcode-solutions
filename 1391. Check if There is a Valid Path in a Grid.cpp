class Solution {
public:
    class DSU {
    public:
        vector<int> parent;
        vector<int> rank;

        DSU(int n) : parent(n), rank(n, 1) {
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int n) {
            if (parent[n] != n) {
                parent[n] = find(parent[n]);
            }
            return parent[n];
        }

        void union_sets(int x, int y) {
            int p1 = find(x);
            int p2 = find(y);
            if (p1 == p2) return;

            if (rank[p1] > rank[p2]) {
                parent[p2] = p1;
            } else if (rank[p1] < rank[p2]) {
                parent[p1] = p2;
            } else {
                parent[p1] = p2;
                rank[p2]++;
            }
        }
    };

    bool getDir(const vector<vector<int>>& grid, int i, int j, int pi, int pj) {
        if (i < 0 || j < 0 || i >= (int)grid.size() || j >= (int)grid[0].size()) return false;
        switch (grid[i][j]) {
            case 1:
                return (j + 1 == pj && i == pi) || (i == pi && j - 1 == pj);
            case 2:
                return (j == pj && i - 1 == pi) || (i + 1 == pi && j == pj);
            case 3:
                return (j - 1 == pj && i == pi) || (i - 1 == pi && j == pj);
            case 4:
                return (j + 1 == pj && i == pi) || (i + 1 == pi && j == pj);
            case 5:
                return (j == pj && i - 1 == pi) || (i == pi && j - 1 == pj);
            case 6:
                return (j + 1 == pj && i == pi) || (i - 1 == pi && j == pj);
        }
        return false;
    }

    bool hasValidPath(vector<vector<int>>& grid) {
        int n = (int)grid.size(), m = (int)grid[0].size();
        DSU dsu(n * m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int index = i * m + j;
                int dir1[2] = {0, 0};
                int dir2[2] = {0, 0};

                switch (grid[i][j]) {
                    case 1:
                        dir1[1] = -1;
                        dir2[1] = 1;
                        break;
                    case 2:
                        dir1[0] = 1;
                        dir2[0] = -1;
                        break;
                    case 3:
                        dir1[0] = 1;
                        dir2[1] = -1;
                        break;
                    case 4:
                        dir1[0] = 1;
                        dir2[1] = 1;
                        break;
                    case 5:
                        dir1[0] = -1;
                        dir2[1] = -1;
                        break;
                    case 6:
                        dir1[0] = -1;
                        dir2[1] = 1;
                        break;
                }

                int ni1 = i + dir1[0], nj1 = j + dir1[1];
                int ni2 = i + dir2[0], nj2 = j + dir2[1];
                int next1 = ni1 * m + nj1;
                int next2 = ni2 * m + nj2;

                if (getDir(grid, ni1, nj1, i, j)) dsu.union_sets(index, next1);
                if (getDir(grid, ni2, nj2, i, j)) dsu.union_sets(index, next2);
            }
        }

        return dsu.find(0) == dsu.find(n * m - 1);
    }
};