class Solution {
    public int maximumGap(String skill, String station) {
        int[] left = new int[skill.length()];
        int[] right = new int[skill.length()];

        int index = 0;
        for(int i = 0; i < station.length() && index < skill.length(); i++){
            if(station.charAt(i) == skill.charAt(index)){
                left[index] = i;
                index++;
            }
        }

        index = skill.length() - 1;
        for(int i = station.length() - 1; i >= 0 && index >= 0; i--){
            if(station.charAt(i) == skill.charAt(index)){
                right[index] = i;
                index--;
            }
        }

        int ans = 0;
        for(int i = 0; i < skill.length() - 1; i++){
            ans = Math.max(ans, right[i + 1] - left[i]);
        }

        return ans;
    }
}