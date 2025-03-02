class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (nums1[i][0] < nums2[j][0]) {
                res.add(new int[]{nums1[i][0], nums1[i][1]});
                i++;
            } else if (nums2[j][0] < nums1[i][0]) {
                res.add(new int[]{nums2[j][0], nums2[j][1]});
                j++;
            } else {
                res.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            }
        }

        while (i < n1) {
            res.add(new int[]{nums1[i][0], nums1[i][1]});
            i++;
        }

        while (j < n2) {
            res.add(new int[]{nums2[j][0], nums2[j][1]});
            j++;
        }

        return res.toArray(new int[res.size()][]);
    }
}