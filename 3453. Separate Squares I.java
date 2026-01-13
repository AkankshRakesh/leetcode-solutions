class Solution {
    public double separateSquares(int[][] squares) {
        double left = Double.MAX_VALUE;
        double right = Double.MIN_VALUE;
        double totalArea = 0;

        for (int[] s : squares) {
            left = Math.min(left, s[1]);
            right = Math.max(right, s[1] + s[2]);
            totalArea += (double) s[2] * s[2];
        }

        double ans = -1;
        while(right - left > 1e-6){
            double mid = left + (right - left) / 2;
            double areaAbove = 0;
            for(int[] square : squares){
                if(square[1] > mid) areaAbove += (double)square[2] * square[2];
                else if(square[1] + square[2] > mid){
                    double len = (double)(square[1] + square[2]) - mid;
                    areaAbove += (double)len * square[2];
                }
            }  

            double areaBelow = totalArea / 2;
            

            if(areaAbove > areaBelow) left = mid;
            else{
                ans = mid;
                right = mid;
            }
        }

        return ans;
    }
}