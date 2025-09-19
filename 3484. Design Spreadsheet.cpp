class Spreadsheet {
    unordered_map<char, unordered_map<int, int>> hm;
public:
    Spreadsheet(int rows) {
    }

    void setCell(string cell, int value) {
        char col = cell[0];
        if (!hm.count(col)) hm[col] = unordered_map<int, int>();
        auto &rows = hm[col];
        int row = 0;
        for (int i = 1; i < (int)cell.size(); i++) {
            row *= 10;
            row += (cell[i] - '0');
        }
        rows[row] = value;
    }

    void resetCell(string cell) {
        char col = cell[0];
        if (!hm.count(col)) hm[col] = unordered_map<int, int>();
        auto &rows = hm[col];
        int row = 0;
        for (int i = 1; i < (int)cell.size(); i++) {
            row *= 10;
            row += (cell[i] - '0');
        }
        rows[row] = 0;
    }

    int get(const string &sb) {
        int res = 0;
        if (sb[0] >= 'A' && sb[0] <= 'Z') {
            char col = sb[0];
            if (hm.count(col)) {
                auto &rows = hm[col];
                int row = 0;
                for (int i = 1; i < (int)sb.size(); i++) {
                    row *= 10;
                    row += (sb[i] - '0');
                }
                if (rows.count(row)) res = rows[row];
            }
        } else {
            res = stoi(sb);
        }
        return res;
    }

    int getValue(string formula) {
        string x;
        int i = 1;
        for (i = 1; formula[i] != '+'; i++) x.push_back(formula[i]);

        i++;
        string y;
        for (; i < (int)formula.size(); i++) y.push_back(formula[i]);

        int xVal = get(x);
        int yVal = get(y);
        return xVal + yVal;
    }
};
