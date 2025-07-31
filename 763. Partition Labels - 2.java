class Solution {
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> arr = new ArrayList<>();
        int n = s.length();

        boolean[][] front = new boolean[n][26];
        boolean[][] back = new boolean[n][26];

        front[0][s.charAt(0) - 'a'] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                front[i][j] = front[i - 1][j];
            }
            front[i][s.charAt(i) - 'a'] = true;
        }

        back[n - 1][s.charAt(n - 1) - 'a'] = true;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                back[i][j] = back[i + 1][j];
            }
            back[i][s.charAt(i) - 'a'] = true;
        }

        int lastInd = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean res = true;
            for (int j = 0; j < 26; j++) {
                if (front[i][j] && back[i + 1][j]) {
                    System.out.println(j);
                    res = false;
                    break;
                }
            }
            if (res) {
                arr.add(i - lastInd + 1);
                lastInd = i + 1;
            }
        }

        arr.add(n - lastInd);
        return arr;
    }
}