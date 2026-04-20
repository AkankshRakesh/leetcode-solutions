class Solution {
    public int maxDistance(int[] colors) {
        int ans = 0;
        for(int i = colors.length - 1; i >= 1; i--){
            if(colors[i] != colors[0]){
                ans = Math.max(ans, i);
                break;
            }
        }
        for(int i = 0; i < colors.length; i++){
            if(colors[i] != colors[colors.length - 1]){
                ans = Math.max(ans, colors.length - 1 - i);
                break;
            }
        }

        return ans;
    }
}