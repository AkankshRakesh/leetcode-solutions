class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        m = len(matrix)
        if m == 0: return
        n = len(matrix[0])

        first_row = matrix[0]
        first_row_zero = any(x == 0 for x in first_row)
        first_col_zero = any(matrix[i][0] == 0 for i in range(m))

        for i in range(1, m):
            row = matrix[i]
            for j in range(1, n):
                if row[j] == 0:
                    row[0] = 0
                    first_row[j] = 0

        for i in range(1, m):
            row = matrix[i]
            mark = row[0]
            for j in range(1, n):
                if mark == 0 or first_row[j] == 0:
                    row[j] = 0

        if first_row_zero:
            for j in range(n):
                first_row[j] = 0

        if first_col_zero:
            for i in range(m):
                matrix[i][0] = 0