class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int ax = rec1[0], ay = rec1[1], bx = rec1[2], by = rec1[3];
        int cx = rec2[0], cy = rec2[1], dx = rec2[2], dy = rec2[3];

        if(ax == bx || ay == by || cx == dx || cy == dy) return false;

        if(bx <= cx || dx <= ax || dy <= ay || by <= cy) return false;
        return true;
    }
}